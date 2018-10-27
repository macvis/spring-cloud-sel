package com.tee.springcloudsel.order.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 订单详情实体类
 *
 * @author youchao.wen
 * @date 2018/9/15.
 */
@Data
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = -1252673749259001365L;
    /**
     * 主键
     */
    private String detailId;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 产品id
     */
    private String productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 当前价格,单位分
     */
    private BigDecimal productPrice;

    /**
     * 数量
     */
    private Integer productQuantity;

    /**
     * 小图
     */
    private String productIcon;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 修改时间
     */
    private Timestamp updateTime;
}
