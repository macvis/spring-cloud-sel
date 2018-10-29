package com.tee.springcloudsel.order.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author youchao.wen
 * @date 2018/10/27.
 */
@Data
public class OrderRequestDTO implements Serializable {

    private static final long serialVersionUID = 4285499152026939616L;

    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号必填")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;

    @NotEmpty(message = "微信openid必填")
    private String openid;

    @NotEmpty(message = "物品必填")
    private String items;
}
