package com.springapp.mvc.controller;

import com.springapp.mvc.service.IUserPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017-09-27 0027.
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    IUserPicService userPicService;
    /**
     * 文件上传功能
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/upload",method= RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file,HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(path);
        String fileName = file.getOriginalFilename();
        String oldFileName = fileName.substring(0,fileName.lastIndexOf("."));
        String filePrefix = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
        Date date = new Date();
        String newFileName = "user_pic:"+date.getTime();
        File dir = new File(path,newFileName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);
        String result = userPicService.saveUserPic(oldFileName,newFileName,path,filePrefix);
        return result;
    }

    /**
     * 文件下载功能
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/down")
    public void down(HttpServletRequest request,HttpServletResponse response) throws Exception{
        //模拟文件，myfile.txt为需要下载的文件
        String fileName = request.getSession().getServletContext().getRealPath("/upload")+"/自测报告.docx";
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
        //假如以中文名下载的话
        String filename = "下载文件.docx";
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename, "UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
    }

    @RequestMapping("/toFile")
    public String toFile(){
        return "/filePages/file";
    }

    @RequestMapping("/getAllFileByPath")
    public String getAllFileByPath(@RequestParam(value = "pathName") String path, ModelMap model){
        List fileList = new ArrayList();
        traverseFolder2(path,fileList);
        model.put("fileList",fileList);
        model.put("pathName",path);
        return "/filePages/file";
    }



    public void traverseFolder2(String path,List list) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
                list.add("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        list.add("文件夹:" + file2.getAbsolutePath());
                        traverseFolder2(file2.getAbsolutePath(), list);
                    } else {
                        System.out.println("文件:" + file2.getAbsolutePath());
                        list.add("文件:" + file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
            list.add("文件不存在!");
        }
    }

}
