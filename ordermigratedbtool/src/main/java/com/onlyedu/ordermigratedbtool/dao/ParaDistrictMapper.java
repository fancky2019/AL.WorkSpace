package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.ParaDistrict;
import com.onlyedu.ordermigratedbtool.model.entity.School;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ParaDistrictMapper {

    List<ParaDistrict> getAll();

}