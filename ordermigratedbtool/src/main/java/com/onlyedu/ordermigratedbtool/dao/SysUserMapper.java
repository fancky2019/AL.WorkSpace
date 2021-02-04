package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper {
    SysUser selectByPrimaryKey(Integer id);

    SysUser selectByAdminUserName(String adminUserName);
}