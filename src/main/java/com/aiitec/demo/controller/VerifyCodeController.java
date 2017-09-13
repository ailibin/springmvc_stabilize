package com.aiitec.demo.controller;


import com.aiitec.demo.model.util.Captcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 该controller主要处理生成验证码
 */
@Controller
public class VerifyCodeController {

    // 验证码页面
    @RequestMapping(value = "/admin/kaptcha", method = RequestMethod.GET)
    public void kaptcha(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        Captcha randomValidateCode = new Captcha();
        try {
            randomValidateCode.getRandcode(request, response);// 输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
