package com.onlyedu.ordermigratedbtool.controller;

import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.service.EosOrderService;
import com.onlyedu.ordermigratedbtool.service.OrderHeadService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/eosOrder")
public class EosOrderController {
    private final static Logger logger = LogManager.getLogger(EosOrderController.class);

    @Autowired
    private EosOrderService eosOrderService;

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
            messageResult = eosOrderService.importData(fileFullName);
        } catch (Exception e) {
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
            logger.error(e.toString());
        }
        return messageResult;
    }

}
