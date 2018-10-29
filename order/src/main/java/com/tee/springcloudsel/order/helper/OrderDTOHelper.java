package com.tee.springcloudsel.order.helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tee.springcloudsel.order.domain.OrderDetail;
import com.tee.springcloudsel.order.domain.OrderMaster;
import com.tee.springcloudsel.order.dto.OrderDTO;
import com.tee.springcloudsel.order.dto.OrderRequestDTO;
import com.tee.springcloudsel.order.enums.ResultEnum;
import com.tee.springcloudsel.order.exception.OrderException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * OrderDTO的属性辅助类
 *
 * @author youchao.wen
 * @date 2018/10/27.
 */
@Log4j2
public class OrderDTOHelper {

    public static OrderMaster convert2OrderMaster(OrderDTO orderDTO) {
        OrderMaster om = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, om);

        return om;
    }

    public static OrderDTO convertFromOrderMaster(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);

        return orderDTO;
    }

    public static OrderDTO convertFromOrderRequestDTO(OrderRequestDTO requestDTO) throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(requestDTO.getName());
        orderDTO.setBuyerPhone(requestDTO.getPhone());
        orderDTO.setBuyerAddress(requestDTO.getAddress());
        orderDTO.setBuyerOpenid(requestDTO.getOpenid());

        Gson gson = new Gson();

        List<OrderDetail> orderList = new ArrayList<>();
        try{
            orderList = gson.fromJson(requestDTO.getItems(), new TypeToken<List<OrderDetail>>(){}.getType());
        }catch(Exception e){
            log.info("gson转换出错", e);
            throw new OrderException(ResultEnum.PARAM_VALIDATE_FAILED);
        }

        orderDTO.setOrderDetailList(orderList);


        return orderDTO;
    }
}
