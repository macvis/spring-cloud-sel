package com.tee.springcloudsel.springcloudsel.constant;

import lombok.Getter;

/**
 * 支付状态
 *
 * @author youchao.wen
 * @date 2018/9/23.
 */
@Getter
public enum PayStatus {
    /**
     * 默认状态
     */
    UNPAID(0, "未支付"),
    PAYING(1, "支付中"),
    PAID(2, "已支付");

    private Integer value;

    private String desc;

    PayStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

}
