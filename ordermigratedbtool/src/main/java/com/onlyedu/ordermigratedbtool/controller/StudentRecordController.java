package com.onlyedu.ordermigratedbtool.controller;

import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.service.EosStudentService;
import com.onlyedu.ordermigratedbtool.service.StudentRecordService;
import com.onlyedu.ordermigratedbtool.utility.CsvUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/studentrecord")
public class StudentRecordController {
    private final static Logger logger = LogManager.getLogger(StudentRecordController.class);

    private StudentRecordService studentRecordService;

    @Autowired
    public StudentRecordController(StudentRecordService studentRecordService) {
        this.studentRecordService = studentRecordService;
    }

    @RequestMapping(value = "/importData", method = RequestMethod.POST)
    public MessageResult<Void> importData(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        MessageResult<Void> messageResult = new MessageResult<>();
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
            File existFile = new File(fileFullName);
            if (existFile.exists()) {
                existFile.delete();
            }
            file.transferTo(existFile);

            messageResult = studentRecordService.importData(fileFullName, getRepeatFileFullName());
        } catch (Exception e) {
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
            logger.error(e.toString());
        }
        return messageResult;
    }

    @RequestMapping(value = "/downloadRepeat", method = RequestMethod.GET)
    public void downloadRepeat(HttpServletResponse response) {
        try {
            if (!CsvUtil.downloadFile(response, getRepeatFileFullName())) {
                logger.info("下载失败！");
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }

    }

    private String getRepeatFileFullName() {
        String rootPath = System.getProperty("user.dir");
//            String rootPath1 = ResourceUtils.getURL("classpath:").getPath();
        String repeatFileDirectory = rootPath + "\\" + "studentrecord" + "\\";
        File repeatFile = new File(repeatFileDirectory);
        //判断路径是否存在,和C#不一样。她判断路径或文件是否存在
        if (!repeatFile.exists()) {
            repeatFile.mkdirs();
        }

        String repeatFileFullName = repeatFileDirectory + "RepeatRecord.csv";
        return repeatFileFullName;
    }

}
