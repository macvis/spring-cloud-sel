package com.tee.springcloudsel.order.service;


import com.tee.springcloudsel.order.dto.OrderDTO;

/**
 * 订单服务的Service
 *
 * @author youchao.wen
 * @date 2018/10/27.
 */
public interface OrderService {
    /**
     * 创建新订单
     * @param requestDTO
     * @return
     */
    OrderDTO createOrder(OrderDTO requestDTO);


}
