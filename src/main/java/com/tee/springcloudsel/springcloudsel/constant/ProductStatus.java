package com.tee.springcloudsel.springcloudsel.constant;

import lombok.Getter;

/**
 * 商品状态
 *
 * @author youchao.wen
 * @date 2018/9/23.
 */
@Getter
public enum ProductStatus {
    /**
     * 默认的商品状态
     */
    NORMAL(0, "正常"),
    SOLD_OUT(1, "下架");

    private Integer value;

    private String desc;

    ProductStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
