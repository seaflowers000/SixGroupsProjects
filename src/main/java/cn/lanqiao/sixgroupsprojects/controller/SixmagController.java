package cn.lanqiao.sixgroupsprojects.controller;

import cn.hutool.core.util.IdUtil;

import cn.lanqiao.sixgroupsprojects.model.dto.SixmagLogin;

import cn.lanqiao.sixgroupsprojects.model.pojo.Manager;
import cn.lanqiao.sixgroupsprojects.model.vo.MagVO;
import cn.lanqiao.sixgroupsprojects.service.SixmagService;
import cn.lanqiao.sixgroupsprojects.utils.ResponseUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static cn.lanqiao.sixgroupsprojects.model.common.FinalClass.MOBILE_PHONE_CAPTCHA_PREFIX;
import static cn.lanqiao.sixgroupsprojects.model.common.FinalClass.USER_TOKEN;


@RestController
@RequestMapping("/Six")
public class SixmagController {
    @Autowired
    private SixmagService SixmagService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private static final ObjectMapper mapper=new ObjectMapper();
    //注册
    @RequestMapping("/register")
    public ResponseUtils<String> register(@RequestBody Manager mag, HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            String verificationCode=(String) session.getAttribute("verificationcode");
            String userCode = mag.getCode();
            if (verificationCode.equalsIgnoreCase(userCode)){
                int result = SixmagService.register(mag);
                return (result == 1) ? new ResponseUtils<String>(200, "注册成功") : new ResponseUtils<String>(500, "注册失败");
            }else{
                return new ResponseUtils<String>(500,"验证码错误");
            }


        }catch (Exception e){
            e.printStackTrace();
            return  new ResponseUtils<String>(400,"数据注册异常");
        }
    }
    //登录
    @RequestMapping("/login")
    public ResponseUtils<String> login(@RequestBody SixmagLogin mag, HttpServletResponse response, HttpServletRequest request){
        try{
            //先判断用户验证码是否正确
            //拿到验证码和ssion存储的验证码
            HttpSession session=request.getSession();
            //msql
//            String uuiDcode=(String) session.getAttribute("UUIDcode");
            //redis
            String phonecode = stringRedisTemplate.opsForValue().get(MOBILE_PHONE_CAPTCHA_PREFIX+ mag.getPhone());


            if(mag.getVerifyCode().equals(phonecode)){
                Manager userLogin=SixmagService.login(mag);
                System.out.println(userLogin);
                if (userLogin==null){
                    return new ResponseUtils(500,"登入失败");
                }else {
                    System.out.println(mag.isRemember());
                    if (mag.isRemember()){
                        Cookie cookie1=new Cookie("uname", URLEncoder.encode(userLogin.getLoginName(),"UTF-8"));
                        Cookie cookie2=new Cookie("pword", URLEncoder.encode(userLogin.getPassword(),"UTF-8"));
                        cookie1.setMaxAge(60*60*24*7);
                        cookie2.setMaxAge(60*60*24*7);
                        cookie1.setPath("/");
                        cookie2.setPath("/");
                        response.addCookie(cookie1);
                        response.addCookie(cookie2);
                    }
                    Cookie cookie3=new Cookie("userId", URLEncoder.encode(String.valueOf(userLogin.getId()),"UTF-8"));
                    cookie3.setPath("/");
                    response.addCookie(cookie3);

                    //tUserVO为了脱敏
                    MagVO tUserVO=new MagVO();
                    tUserVO.setId(userLogin.getId());
                    tUserVO.setRole(userLogin.getRole());
                    System.out.println("需要响应的数据:"+tUserVO);

                    //登入后存信息 拦截器需要
                    session.setAttribute("userLogin",userLogin);

                    //生成一个token
                    String token = IdUtil.fastSimpleUUID();
                    tUserVO.setToken(token);
                    //  使用token构建一个唯一的redis key
                    String redisKey=USER_TOKEN + token;
                    //怎么将用户信息存入redis
                    String userLoginJson=mapper.writeValueAsString(userLogin);
                    stringRedisTemplate.opsForValue().set(redisKey,userLoginJson,30L, TimeUnit.MINUTES);


                    return new ResponseUtils(200,"登入成功",tUserVO);
                } }else {
                return new ResponseUtils(500,"手机验证码错误");}

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseUtils(400,"登入查询异常");
        }
    }

}




