package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.UserCallByWhy;
import com.onlyedu.ordermigratedbtool.model.entity.UserIntention;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserCallByWhyMapper {
    List<UserCallByWhy> getAll();

    int insert(UserCallByWhy record);


}