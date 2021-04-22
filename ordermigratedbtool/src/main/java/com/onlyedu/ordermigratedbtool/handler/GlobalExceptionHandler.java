package com.onlyedu.ordermigratedbtool.handler;


import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 * 该类放在单独一个文件夹
 * <p>
 * extends ResponseEntityExceptionHandler
 */
@ControllerAdvice
//@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public MessageResult<Void> exceptionHandler(Exception ex, WebRequest request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json;charset=UTF-8");

        MessageResult<Void> messageResult = new MessageResult<>();
        messageResult.setCode(500);
        messageResult.setMessage(ex.getMessage());
//ResponseEntity.ok(messageResult);
        return messageResult;
    }
}
