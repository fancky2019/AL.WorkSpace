package com.onlyedu.ordermigratedbtool.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.onlyedu.ordermigratedbtool.model.pojo.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentOrderDto extends Page {
    private Integer id;
    /**
     * 前端：字符串之间用逗号分隔。
     */
    private List<String> studentIds;
    private String studentId;
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
