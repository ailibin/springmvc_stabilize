package com.aiitec.demo.controller;


import com.aiitec.demo.model.component.LoginComponent;
import com.aiitec.demo.model.component.UserInfoComponent;
import com.aiitec.demo.model.entity.UserTestEntity;
import com.aiitec.demo.model.util.AlertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.swing.*;

@Controller
public class LoginController {

    @Autowired
    LoginComponent loginComponent;

    @Autowired
    UserInfoComponent userInfoComponent;

    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public String userLogin() {
        return "admin/login";
    }

    @RequestMapping(value = "/admin/login/submit", method = RequestMethod.POST)
    public String userSubmit(@ModelAttribute("login") UserTestEntity userTestEntity, ModelMap modelMap) {
        boolean result = false;
        result = loginComponent.confirmLoginInfo(userTestEntity);
        if(result){
            //使用重定向的方式成功跳转到用户界面(并把用户的参数传递给jsp页面)
            modelMap.addAttribute("userList", userInfoComponent.getAllUsers(1));
            return "redirect:/admin/users";//如果是"return admin/users"返回的是当前的地址也就是(/admin/login/submit)
        }else{
            //当前界面
            AlertUtil.showMessageDialog(null,"登陆信息不正确","登陆失败", JOptionPane.ERROR_MESSAGE);
            return "admin/login";
        }

    }

}
