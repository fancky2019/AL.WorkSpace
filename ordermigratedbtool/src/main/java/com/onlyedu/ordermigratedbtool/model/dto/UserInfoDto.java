package com.onlyedu.ordermigratedbtool.model.dto;

import com.onlyedu.ordermigratedbtool.model.pojo.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserInfoDto extends Page {
    private Integer id;
    private String userId;
    private String studentId;
    private String userName;
    private String grade;
    private String mobilePhone;
    private String tel;
    private String school;
    private LocalDateTime regTime;
    private Boolean relativeState;
    private String eOSUserInfo;
    private List<String> names;
}
