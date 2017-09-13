package com.aiitec.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CanvasController {

    @RequestMapping(value = "admin/canvas/test",method = RequestMethod.GET)
    public String showTime(){
        return "admin/canvasTime";
    }
}
