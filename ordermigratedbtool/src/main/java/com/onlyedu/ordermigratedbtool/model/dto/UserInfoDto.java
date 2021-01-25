package com.onlyedu.ordermigratedbtool.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.onlyedu.ordermigratedbtool.model.pojo.Page;
import com.onlyedu.ordermigratedbtool.utility.Jackson.JacksonLocalDateTimeDeserializer;
import com.onlyedu.ordermigratedbtool.utility.Jackson.JacksonLocalDateTimeSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserInfoDto extends Page {
    private Integer id;
    private String userId;
    private List<String> studentIds;
    private String studentId;
    private String studentNo;
    private String userName;
    private String grade;
    private String mobilePhone;
    private String tel;
    private String school;
    //前端传给后端不能解析值
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime regTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime regStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime regEndTime;
    private Boolean relativeState;
    private Integer eosStudentID;
    private List<String> names;
}
