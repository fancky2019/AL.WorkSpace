package com.onlyedu.ordermigratedbtool.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class StudentOrderVO {
    private  Integer id;
    private String orderNo;
    private String courseWareName;
    private Integer orderProductId;
    private String productName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime addedTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime courseStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime courseEndTime;
    private String orderType;
    private String payType;
    private String shareUserId;
    private String payMoney;
    private String relativeStateStr;
    private Boolean relativeState;
    private String eosOrderNos;
    private String eosProductIds;
    private String eosOrderIds;
    private BigDecimal orderBalance;
    private BigDecimal eosRemainBalance;
}
