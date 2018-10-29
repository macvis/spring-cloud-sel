package com.tee.springcloudsel.order.exception;

import com.tee.springcloudsel.order.enums.ResultEnum;

/**
 * @author youchao.wen
 * @date 2018/10/27.
 */
public class OrderException extends Exception {

    private Integer code;

    public OrderException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
