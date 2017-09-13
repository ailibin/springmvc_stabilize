package com.aiitec.demo.controller;

import com.aiitec.demo.model.component.RegisterComponent;
import com.aiitec.demo.model.entity.UserTestEntity;
import com.aiitec.demo.model.repository.UserTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    @Autowired
    RegisterComponent registerComponent;
    @Autowired
    UserTestRepository userTestRepository;

    @RequestMapping(value = "/admin/register",method = RequestMethod.GET)
    public String userRegister(){
        return "admin/register";
    }

    @RequestMapping(value = "/admin/register/submit",method = RequestMethod.POST)
    public String registerSubmit(@ModelAttribute("register")UserTestEntity userTestEntity, ModelMap modelMap){
        System.out.println("password:"+userTestEntity.getPassword());
        System.out.println("username:"+userTestEntity.getUsername());
        System.out.println("email:"+userTestEntity.getEmail());

        userTestRepository.saveAndFlush(userTestEntity);
        return "redirect:/admin/login";
    }
}
