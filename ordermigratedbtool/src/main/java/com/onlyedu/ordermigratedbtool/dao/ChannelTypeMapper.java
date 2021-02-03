package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.ChannelType;
import com.onlyedu.ordermigratedbtool.model.entity.ParaDistrict;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ChannelTypeMapper {

    List<ChannelType> getAll();
}