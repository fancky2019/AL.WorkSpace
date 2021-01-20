package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.EosOrder;

public interface EosOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EosOrder record);

    int insertSelective(EosOrder record);

    EosOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EosOrder record);

    int updateByPrimaryKey(EosOrder record);
}