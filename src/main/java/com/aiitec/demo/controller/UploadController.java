package com.aiitec.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class UploadController {
    //多文件上传
    @RequestMapping(value = "/file/upload")
    public String addUser(@RequestParam("file") CommonsMultipartFile[] files, HttpServletRequest request, ModelMap modelMap) {
        //方式一：使用流的形式进行上传
        for (int i = 0; i < files.length; i++) {
            System.out.println("fileName---------->" + files[i].getOriginalFilename());

            if (!files[i].isEmpty()) {
                int pre = (int) System.currentTimeMillis();
                try {
                    //获取当前工程webapp的根目录(D:\javaworkspace\SpringMVCDemo1\out\artifacts\springdemo_list_war_exploded2\)
//                    String rootPath = System.getProperty("root");
//                    System.out.println("rootPath:" + rootPath);
                    String rootPath = request.getSession().getServletContext().getRealPath("");
                    //拿到输出流，同时重命名上传的文件
                    FileOutputStream os = new FileOutputStream(rootPath + new Date().getTime() + files[i].getOriginalFilename());
                    //拿到上传文件的输入流
                    FileInputStream in = (FileInputStream) files[i].getInputStream();

                    //以写字节的方式写文件
                    int b = 0;
                    while ((b = in.read()) != -1) {
                        os.write(b);
                    }
                    os.flush();
                    os.close();
                    in.close();
                    int finaltime = (int) System.currentTimeMillis();
                    modelMap.addAttribute("text", "上传成功");
                    System.out.println(finaltime - pre);

                } catch (Exception e) {
                    e.printStackTrace();
                    modelMap.addAttribute("text", "上传失败");
                    System.out.println("上传出错");
                }
            }
        }
        return "admin/success";
    }

    //方式二使用springmvc中解析文件的方式
    @RequestMapping(value = "/file/upload2")
    public String upload2(HttpServletRequest request, ModelMap modelMap,@RequestParam("file") CommonsMultipartFile[] files) throws IllegalStateException, IOException {
        //这里弄一个集合用来保存所有的图片地址,用来回显
        List<String> fileList = new ArrayList<>();
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //取得request中的所有文件名
            Iterator<String> filesName = multiRequest.getFileNames();
            while (filesName.hasNext()) {
                //记录上传过程起始时的时间，用来计算上传时间
                int pre = (int) System.currentTimeMillis();
                //取得上传文件
                MultipartFile file = multiRequest.getFile(filesName.next());
                if (file != null) {
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        System.out.println(myFileName);
                        //重命名上传后的文件名(这里路径名不能有“：”或者“-”等特殊的字符)
                        String rootPath = request.getSession().getServletContext().getRealPath("");
                        String fileName = "springUpload" + new Date().getTime() + file.getOriginalFilename();
                        //定义上传路径
                        String path = rootPath + fileName;
                        File localFile = new File(path);
                        //保存到指定的路径
                        file.transferTo(localFile);
                        modelMap.addAttribute("text", "上传成功");
                        //保存路径,用于网页回显
                        fileList.add(path);
                    }
                } else {
                    modelMap.addAttribute("text", "上传失败");
                }
                //记录上传该文件后的时间
                int finaltime = (int) System.currentTimeMillis();
                System.out.println(finaltime - pre);
            }
            modelMap.addAttribute("fileList",fileList);

        }
        return "admin/success";
    }

    @RequestMapping("/userImg/toUpload")
    public String toUpload() {
        return "admin/upload";
    }

    @RequestMapping(value = "/test/path", method = RequestMethod.GET)
    @ResponseBody
    public String testPath(HttpServletRequest request) throws Exception {
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        //获取webapp的物理路径(D:\javaworkspace\SpringMVCDemo1\out\artifacts\springdemo_list_war_exploded2\)
        String pathRoot = request.getSession().getServletContext().getRealPath("");
        System.out.println("contextPath:" + contextPath + "  " +
                "servletPath:" + servletPath + "  " + "rootPath:"
                +"  "+"pathRoot:"+pathRoot
        );
        return "test ok";
    }

}
