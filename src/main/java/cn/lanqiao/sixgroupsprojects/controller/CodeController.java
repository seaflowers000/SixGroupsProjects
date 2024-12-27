package cn.lanqiao.sixgroupsprojects.controller;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.UnexpectedException;
import java.util.Random;

@Controller
public class CodeController extends HttpServlet {
    @RequestMapping("/codeImage")
    protected void doGet    (HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException {
        //处理请求和响应编码
        //处理请求和响应编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        // System.out.println("注册验证码请求过来了");
        //验证码图片宽和高
        int length = 171;
        int width = 50;
        //绘图类--画布--画布Green Blue Red
        BufferedImage bufferedImage = new BufferedImage(length, width, BufferedImage.TYPE_INT_RGB);
        //获取一个画笔
        Graphics g = bufferedImage.getGraphics();
        //设置画笔为白色
        g.setColor(Color.white);
        //使用画笔填充矩形边框
        g.fillRect(0, 0, length, width);
        //颜色数组
        Color[] colors = {Color.red,Color.yellow,Color.green,Color.cyan,Color.pink,Color.orange,Color.blue,Color.darkGray,Color.LIGHT_GRAY};
        //验证码的内容
        String[] codes = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
                "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        //随机数，随机的中字母和数字中获取4个
        Random ran = new Random();
        //Stringbuilder是用来存储生成出来的验证码
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(codes.length);
            String str = String.valueOf(codes[index]);
            //随机的画笔颜色
            g.setColor(colors[ran.nextInt(colors.length)]);
            //设置字体
            g.setFont(new Font("宋体",Font.BOLD,30+ran.nextInt(10)));
            //绘制字到图片上
            g.drawString(str, 1 + (width/2)*i, 30 + ran.nextInt(10));
            //将生成出来的验证码放入到stringBuilder中
            stringBuilder.append(str);
        }
        //绘制干扰线
        for (int i = 0; i < 4; i++) {
            //随机的画笔颜色
            g.setColor(colors[ran.nextInt(colors.length)])  ;
            int x0=ran.nextInt(length);
            int y0=ran.nextInt(width);
            int x1=ran.nextInt(length);
            int y1=ran.nextInt(width);
            g.drawLine(x0,y0,x1,y1);
        }
        System.out.println(stringBuilder);

        HttpSession session = request.getSession();
        session.setAttribute("verificationcode", stringBuilder.toString());

        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());


    }
}
