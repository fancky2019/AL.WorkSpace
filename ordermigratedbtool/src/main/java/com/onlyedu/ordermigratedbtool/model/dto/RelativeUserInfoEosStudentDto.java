package com.onlyedu.ordermigratedbtool.model.dto;

import com.onlyedu.ordermigratedbtool.model.entity.EosStudent;
import com.onlyedu.ordermigratedbtool.model.entity.UserInfo;
import lombok.Data;

import java.util.List;
@Data
public class RelativeUserInfoEosStudentDto {
    /**
     * UserInfo 多对EosStudent一
     */
    private List<Integer>   userInfoIds;
    private Integer eosStudentId;
}
