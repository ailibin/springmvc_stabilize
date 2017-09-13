package com.aiitec.demo.controller;


import com.aiitec.demo.model.service.ControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * 一个用来测试的Controller
 */
@Controller
public class TestController implements ServletContextAware {


    // @Autowired是根据类型进行自动装配的。如果当spring上下文中存在不止一个ControlService类型的bean时，就会抛出BeanCreationException异常;
    // 如果Spring上下文中不存在ControlService类型的bean，也会抛出BeanCreationException异常。我们可以使用@Qualifier配合@Autowired来解决这些问题。
    // @Qualifier("ControlService")
    // @Autowired(required = false)
    @Autowired(required = false)
//    @Qualifier("ControlService")
    private ControlService controlService;
    private ServletContext application;

    //通过这个方法可以拿到ServletContext
    @Override
    public void setServletContext(ServletContext servletContext) {
        this.application = servletContext;
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        controlService.serviceTest("it's ok");
        return "admin/test";
    }
}
