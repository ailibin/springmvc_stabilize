package com.aiitec.demo.controller;

import com.aiitec.demo.model.component.UploadComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class UploadAvatarController {
    //处理图片上传(该字段可以为空)
    @Autowired
    UploadComponent uploadComponent;
    @RequestMapping(value = "/avatar/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, ModelMap modelMap, @RequestParam(value = "file", required = false) MultipartFile file) throws IllegalStateException, IOException {
        //这里交给uploadcomponent去处理
        uploadComponent.uploadFile(request,modelMap,file);
        return "admin/addUser";
    }

}
