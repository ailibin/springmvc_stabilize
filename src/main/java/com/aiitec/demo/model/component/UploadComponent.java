package com.aiitec.demo.model.component;

import com.aiitec.demo.model.util.AlertUtil;
import com.aiitec.demo.model.util.VerifyImageFileUtil;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Component
public class UploadComponent {
    //处理图片上传(该字段可以为空)这里是单文件上传MultipartFile
    public void uploadFile(HttpServletRequest request, ModelMap modelMap, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
        String defaultUrl = "http://f.hiphotos.baidu.com/image/pic/item/09fa513d269759ee50f1971ab6fb43166c22dfba.jpg";//这个用来测试的图片地址
        if (file != null) {
            //取得当前上传文件的文件名称()
            String myFileName = file.getOriginalFilename();
            //判断是否为图片格式
            if (VerifyImageFileUtil.isImageFile(myFileName)) {// 判断文件类型
                //如果名称不为"",说明该文件存在，否则说明该文件不存在
                if (myFileName.trim() != "") {
                    System.out.println(myFileName);
                    //重命名上传后的文件名(这里路径名不能有“：”或者“-”等特殊的字符)
                    String rootPath = request.getSession().getServletContext().getRealPath("");
                    String fileName = "avatar" + new Date().getTime() + file.getOriginalFilename();
                    //定义上传路径
                    String path = rootPath + fileName;
                    File localFile = new File(path);
                    file.transferTo(localFile);
                    //设置到用户的头像字段中
                    modelMap.addAttribute("userAvatar", fileName);
                    System.out.println("用户头像地址：" + path);
                    AlertUtil.showMessageDialog(null, "上传成功", "success", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                AlertUtil.showMessageDialog(null, "上传的文件类型不对", "alert", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            modelMap.addAttribute("userAvatar", defaultUrl);
        }
    }

}
