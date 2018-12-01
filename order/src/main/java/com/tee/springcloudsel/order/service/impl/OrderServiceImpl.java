package com.tee.springcloudsel.order.service.impl;

import com.tee.springcloudlearning.productclient.client.ProductClient;
import com.tee.springcloudlearning.productclient.dto.ProductCartDTO;
import com.tee.springcloudlearning.productclient.dto.ProductInfoDTO;
import com.tee.springcloudsel.order.constant.OrderStatus;
import com.tee.springcloudsel.order.constant.PayStatus;
import com.tee.springcloudsel.order.domain.OrderDetail;
import com.tee.springcloudsel.order.domain.OrderMaster;
import com.tee.springcloudsel.order.dto.OrderDTO;
import com.tee.springcloudsel.order.helper.OrderDTOHelper;
import com.tee.springcloudsel.order.mapper.OrderDetailMapper;
import com.tee.springcloudsel.order.mapper.OrderMasterMapper;
import com.tee.springcloudsel.order.service.OrderService;
import com.tee.springcloudsel.order.util.IDGenerateUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired(required = false)
    private ProductClient productClient;

    /**
     * 创建订单:
     *
     * @return 调用结果
     */
    @Override
    public OrderDTO createOrder(OrderDTO requestDTO) {
        //查询商品信息(调用商品服务)
        List<String> productIdList = requestDTO.getOrderDetailList().stream()
                .map(OrderDetail::getDetailId)
                .collect(Collectors.toList());
        List<ProductInfoDTO> productInfoList = productClient.listForOrder(productIdList);

        String generatedOrderId = IDGenerateUtil.generateId();

        // 计算总价
        BigDecimal totalSum = new BigDecimal("0");
        for (OrderDetail od : requestDTO.getOrderDetailList()) {

            for(ProductInfoDTO infoDTO : productInfoList){
                if(StringUtils.equals(infoDTO.getProductId(), od.getProductId())){
                    //总价
                    totalSum =
                            totalSum.add(infoDTO.getProductPrice().multiply(new BigDecimal(od.getProductQuantity())));
                    BeanUtils.copyProperties(infoDTO, od);
                    od.setOrderId(generatedOrderId);
                    od.setDetailId(IDGenerateUtil.generateId());
                    //订单详情入库
                    orderDetailMapper.insertOrderDetail(od);
                }
            }


        }

        // 扣库存
        List<ProductCartDTO> cartDTOList = requestDTO.getOrderDetailList().stream()
                .map(cart -> new ProductCartDTO(cart.getProductId(), cart.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);

        //订单入库 mapper.save
        OrderMaster om = OrderDTOHelper.convert2OrderMaster(requestDTO);
        om.setOrderAmount(new BigDecimal("6"));
        om.setOrderStatus(OrderStatus.NEW.getValue());
        om.setPayStatus(PayStatus.PAID.getValue());
        om.setOrderId(generatedOrderId);

        om.setCreateTime(new Timestamp(System.currentTimeMillis()));
        om.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        orderMasterMapper.saveOrderMaster(om);

        return OrderDTOHelper.convertFromOrderMaster(om);
    }
}
