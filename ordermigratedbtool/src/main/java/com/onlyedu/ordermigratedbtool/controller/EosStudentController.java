package com.onlyedu.ordermigratedbtool.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlyedu.ordermigratedbtool.model.dto.EosStudentDto;
import com.onlyedu.ordermigratedbtool.model.dto.RelativeStateDto;
import com.onlyedu.ordermigratedbtool.model.dto.UserInfoDto;
import com.onlyedu.ordermigratedbtool.model.dto.UserInfoStatisticsDto;
import com.onlyedu.ordermigratedbtool.model.entity.EosStudent;
import com.onlyedu.ordermigratedbtool.model.entity.UserInfo;
import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.model.pojo.PageData;
import com.onlyedu.ordermigratedbtool.model.vo.EosStudentVO;
import com.onlyedu.ordermigratedbtool.model.vo.UserInfoVO;
import com.onlyedu.ordermigratedbtool.service.EosStudentService;
import com.onlyedu.ordermigratedbtool.service.UserInfoService;
import com.onlyedu.ordermigratedbtool.utility.ExcelHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/eosStudent")
public class EosStudentController {
    private final static Logger logger = LogManager.getLogger(EosStudentController.class);

    @Autowired
    private EosStudentService eosStudentService;

    @Autowired
    ObjectMapper mapper;


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
            File existFile=  new File(fileFullName);
            if(existFile.exists())
            {
                existFile.delete();
            }
            file.transferTo(existFile);
            messageResult = eosStudentService.importData(fileFullName);
        } catch (Exception e) {
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
            logger.error(e.toString());
        }
        return messageResult;
    }

    @GetMapping("/getEosStudentPage")
    public MessageResult<PageData<EosStudentVO>> getEosStudentPage(EosStudentDto eosStudentDto) {
        MessageResult<PageData<EosStudentVO>> message = eosStudentService.getEosStudentPage(eosStudentDto);
        return message;
    }

    @PostMapping("/updateRelative")
    public MessageResult<Integer> updateRelative(@RequestBody EosStudent eosStudent) {
        MessageResult<Integer> messageResult = eosStudentService.updateRelative(eosStudent);
        return messageResult;
    }

    @GetMapping("/getEosStudentStatistics")
    public MessageResult<UserInfoStatisticsDto> getEosStudentStatistics() {
        return eosStudentService.getEosStudentStatistics();
    }

    @GetMapping("/getGrade")
    public MessageResult<List<String>> getGrade() {
        return eosStudentService.getGrade();
    }

    @GetMapping("/getEosStudentByIdWithRelative")
    public MessageResult<EosStudentVO> getEosStudentByIdWithRelative(Integer eosStudentID) {
        return eosStudentService.getEosStudentByIdWithRelative(eosStudentID);
    }


}

