package com.tee.springcloudsel.product.enums;

import lombok.Getter;

/**
 * @author youchao.wen
 * @date 2018/11/17.
 */
@Getter
public enum  ResultEnum {
    /**
     * 商品不存在
     */
    PRODUCT_NOT_EXIST(501, "商品不存在"),
    PRODUCT_STOCK_UNAVAILABLE(502, "商品库存不足"),
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
