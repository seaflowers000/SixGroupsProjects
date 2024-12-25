package cn.lanqiao.sixgroupsprojects.controller;

import cn.hutool.core.util.IdUtil;
import cn.lanqiao.sixgroupsprojects.model.dto.SixmagLogin;
import cn.lanqiao.sixgroupsprojects.service.SixmagService;
import cn.lanqiao.sixgroupsprojects.utils.ResponseUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

import static cn.lanqiao.sixgroupsprojects.model.common.FinalClass.MOBILE_PHONE_CAPTCHA_PREFIX;

@RestController
@RequestMapping("/tUser")
public class SixTuserController {
    @Autowired
    private SixmagService sixmagService;
    private static final ObjectMapper mapper=new ObjectMapper();

    @RequestMapping("/login")
    public ResponseUtils<String> login(@RequestBody SixmagLogin tUser, HttpServletResponse response, HttpServletRequest request){
        try{
            //先判断用户验证码是否正确
            //拿到验证码和ssion存储的验证码
            HttpSession session=request.getSession();
            //msql
//            String uuiDcode=(String) session.getAttribute("UUIDcode");
            //redis
//            String phonecode = stringRedisTemplate.opsForValue().get(MOBILE_PHONE_CAPTCHA_PREFIX+ tUser.getPhone());


            if(tUser.getVerifyCode().equals(phonecode)){
                TUser userLogin=tuserService.login(tUser);
                System.out.println(userLogin);
                if (userLogin==null){
                    return new ResponseUtils(500,"登入失败");
                }else {
                    System.out.println(tUser.isRemember());
                    if (tUser.isRemember()){
                        Cookie cookie1=new Cookie("uname", URLEncoder.encode(userLogin.getAccount(),"UTF-8"));
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
                    TUserVO tUserVO=new TUserVO();
                    tUserVO.setId(userLogin.getId());
                    tUserVO.setNickname(userLogin.getNickname());
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
