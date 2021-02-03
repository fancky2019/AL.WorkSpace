package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.UserIntention;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserIntentionMapper {
    List<UserIntention> getAll();

    int insert(UserIntention record);


}