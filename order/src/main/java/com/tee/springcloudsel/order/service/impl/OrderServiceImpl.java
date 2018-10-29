package com.tee.springcloudsel.order.service.impl;

import com.tee.springcloudsel.order.constant.OrderStatus;
import com.tee.springcloudsel.order.constant.PayStatus;
import com.tee.springcloudsel.order.domain.OrderMaster;
import com.tee.springcloudsel.order.dto.OrderDTO;
import com.tee.springcloudsel.order.helper.OrderDTOHelper;
import com.tee.springcloudsel.order.mapper.OrderDetailMapper;
import com.tee.springcloudsel.order.mapper.OrderMasterMapper;
import com.tee.springcloudsel.order.service.OrderService;
import com.tee.springcloudsel.order.util.IDGenerateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author youchao.wen
 * @date 2018/10/27.
 */
@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    /**
     * 创建订单:
     * @return 调用结果
     */
    @Override
    public OrderDTO createOrder(OrderDTO requestDTO) {
        // TODO: 2018/10/27 查询商品信息(调用商品服务)，[目前无法完成]
        // TODO 计算总价
        // TODO 扣库存
        //订单入库 mapper.save

        OrderMaster om = OrderDTOHelper.convert2OrderMaster(requestDTO);
        om.setOrderAmount(new BigDecimal("6"));
        om.setOrderStatus(OrderStatus.NEW.getValue());
        om.setPayStatus(PayStatus.PAID.getValue());
        om.setOrderId(IDGenerateUtil.generateId());

        om.setCreateTime(new Timestamp(System.currentTimeMillis()));
        om.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        orderMasterMapper.saveOrderMaster(om);


        return OrderDTOHelper.convertFromOrderMaster(om);
    }
}
