package com.tee.springcloudsel.userinfo.constant;

import lombok.Getter;

/**
 * @author youchao.wen
 * @date 2018/9/23.
 */
@Getter
public enum OrderStatus {
    /**
     * 默认的订单状态
     */
    NEW(0, "新下单"),
    PROCESSING(1, "处理中"),
    DONE(2, "已完成");

    private Integer value;

    private String desc;

    OrderStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

}
