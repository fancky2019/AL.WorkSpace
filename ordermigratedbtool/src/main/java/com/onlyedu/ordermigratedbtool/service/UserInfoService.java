package com.onlyedu.ordermigratedbtool.service;

import com.onlyedu.ordermigratedbtool.dao.UserInfoMapper;
import com.onlyedu.ordermigratedbtool.model.entity.UserInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    private final static Logger logger = LogManager.getLogger(UserInfoService.class);
    @Autowired
    private UserInfoMapper userInfoMapper;


  public   UserInfo getUserWithOrder(String userId)
  {
      logger.info("test");
      return userInfoMapper.getUserWithOrder(userId);
  }
}
