package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.dto.StudentOrderDto;
import com.onlyedu.ordermigratedbtool.model.entity.OrderHead;
import com.onlyedu.ordermigratedbtool.model.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderHeadMapper {
    List<StudentOrderDto> getOrderByStudentGuid(String studentGuid);

    Integer updateRelative(OrderHead record);
}