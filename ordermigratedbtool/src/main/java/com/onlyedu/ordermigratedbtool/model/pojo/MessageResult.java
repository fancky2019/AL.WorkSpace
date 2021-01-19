package com.onlyedu.ordermigratedbtool.model.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
//@EqualsAndHashCode(callSuper = true)
public class MessageResult<T> {

    /**
     * 执行结果（true:成功，false:失败）
     */
    private Integer code;
    private String message;
    private T data;
}
