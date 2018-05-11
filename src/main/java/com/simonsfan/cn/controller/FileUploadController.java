package com.simonsfan.cn.controller;

import com.simonsfan.cn.util.FTPUtil;
import com.simonsfan.cn.util.PropertyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by fanrx on 2018/3/30.
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {
    /**
     * 后期功能需兼容  多文件同时上传
     * springmvc文件上传
     *
     * @param session
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(HttpSession session, @RequestParam(value = "upload_file", required = false) MultipartFile file, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("upload"); //  "/develop/apache-tomcat-7.0.82/webapps/ROOT/upload"
        String targetFileName = FTPUtil.upload(file, path);
        String url = PropertyUtils.getByKey("ftp.server.http.prefix","") + targetFileName;
        return url;
    }
}
