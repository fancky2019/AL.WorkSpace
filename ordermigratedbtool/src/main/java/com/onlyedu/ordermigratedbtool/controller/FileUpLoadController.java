package com.onlyedu.ordermigratedbtool.controller;

import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/fileupload")
public class FileUpLoadController {

    private final static Logger logger = LogManager.getLogger(FileUpLoadController.class);


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public MessageResult<String> upload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        MessageResult<String> messageResult = new MessageResult<>();
        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            String dateStr = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String rootPath = System.getProperty("user.dir");
//            String rootPath =   ResourceUtils.getURL("classpath:").getPath();
            String directory = rootPath + "\\uploadfiles" + "\\" + dateStr + "\\";
            File destFile = new File(directory);
            //判断路径是否存在,和C#不一样。她判断路径和文件是否存在
            if (!destFile.exists()) {
                destFile.mkdirs();
            }

            //获取body中的参数
//            String value = (String)request.getAttribute("paramName");
            //获取文件名称
            String sourceFileName = file.getOriginalFilename();
            //写入目的文件
            String fileFullName = directory + sourceFileName;
            file.transferTo(new File(fileFullName));

            messageResult.setCode(0);
            messageResult.setMessage(fileFullName);

        } catch (Exception e) {
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
            logger.error(e.toString());
        }
        return messageResult;
    }

    @RequestMapping(value = "/uploadFileAndForm", method = RequestMethod.POST)
    public MessageResult<Void> uploadFileAndForm(@RequestParam(value = "files") MultipartFile[] files, HttpServletRequest request) {
        MessageResult<Void> messageResult = new MessageResult<>();
        logger.info("uploadFileAndForm");
        try {
            String suggestion = request.getParameter("suggestion");//取出form-data中a的值
            String phone = request.getParameter("phone");//取出form-data中a的值

            LocalDateTime localDateTime = LocalDateTime.now();
            String dateStr = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String rootPath = System.getProperty("user.dir");
//            String rootPath =   ResourceUtils.getURL("classpath:").getPath();
            String directory = rootPath + "\\uploadfiles" + "\\" + dateStr + "\\";
            File destFile = new File(directory);
            //判断路径是否存在,和C#不一样。她判断路径和文件是否存在
            if (!destFile.exists()) {
                destFile.mkdirs();
            }

            List<String> fileNameList = new ArrayList<>();
            for (MultipartFile file : files) {


                //获取body中的参数
//            String value = (String)request.getAttribute("paramName");
                //获取文件名称
                String sourceFileName = file.getOriginalFilename();
                //写入目的文件
                String fileFullName = directory + sourceFileName;


                file.transferTo(new File(fileFullName));
                fileNameList.add(fileFullName);
            }
            String fileNames = String.join(";", fileNameList);


            messageResult.setCode(0);
        } catch (Exception e) {
            e.printStackTrace();
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
            logger.error(e.toString());
        }
        return messageResult;
    }


    @RequestMapping(value = "/uploadStatus")
    public Integer uploadStatus(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object percent = session.getAttribute("upload_percent");
        return null != percent ? (Integer) percent : 0;
    }


    @RequestMapping(value = "/deleteFile")
    public MessageResult<Void> deleteFile(@RequestBody String filePath) {
        File file = new File(filePath);
        String returnMsg = "";
        MessageResult<Void> message = new MessageResult<>();
        //判断路径是否存在,和C#不一样。她判断路径和文件是否存在
        if (file.exists()) {
            if (file.delete()) {
                returnMsg = "删除成功!";
                message.setCode(0);
            } else {
                returnMsg = "删除失败!";
                message.setCode(500);
            }
        } else {
            returnMsg = "文件不存在!";
            message.setCode(500);
        }


        message.setMessage(returnMsg);
        return message;

    }

}
