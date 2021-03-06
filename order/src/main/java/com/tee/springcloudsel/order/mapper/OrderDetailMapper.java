package com.tee.springcloudsel.order.mapper;

import com.tee.springcloudsel.order.domain.OrderDetail;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * order_detail表的mapper类
 *
 * @author youchao.wen
 * @date 2018/9/15.
 */
@Component
public interface OrderDetailMapper {
    /**
     * 查询所有数据
     *
     * @return 所有数据
     */
    List<OrderDetail> selectAll();

    /**
     * 使用orderId来查询一个订单信息
     * @param orderId
     * @return 订单信息
     */
    OrderDetail selectById(String orderId);

    /**
     * 保存一条orderDetail
     * @param orderDetail 订单详情实体类
     */
    void insertOrderDetail(OrderDetail orderDetail);
}
