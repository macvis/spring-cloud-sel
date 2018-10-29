package com.tee.springcloudsel.order.dto;

import com.tee.springcloudsel.order.domain.OrderDetail;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author youchao.wen
 * @date 2018/10/27.
 */
@Data
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 3644817832038572246L;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 买家名字
     */
    private String buyerName;

    /**
     * 买家电话
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家微信openid
     */
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态, 默认为新下单
     */
    private Integer orderStatus;

    /**
     * 支付状态, 默认未支付
     */
    private Integer payStatus;

    /**
     * 订单列表
     */
    private List<OrderDetail> orderDetailList;
}
