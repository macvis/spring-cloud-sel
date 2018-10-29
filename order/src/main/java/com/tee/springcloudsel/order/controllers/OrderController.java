package com.tee.springcloudsel.order.controllers;

import com.alibaba.fastjson.JSON;
import com.tee.springcloudsel.order.dto.OrderDTO;
import com.tee.springcloudsel.order.dto.OrderRequestDTO;
import com.tee.springcloudsel.order.enums.ResultEnum;
import com.tee.springcloudsel.order.exception.OrderException;
import com.tee.springcloudsel.order.helper.OrderDTOHelper;
import com.tee.springcloudsel.order.service.OrderService;
import com.tee.springcloudsel.order.util.ResultVOUtil;
import com.tee.springcloudsel.springcloudsel.dto.ResultVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 订单服务的controller
 *
 * @author youchao.wen
 * @date 2018/10/21.
 */
@RestController
@RequestMapping(value = "/order")
@Log4j2
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单:
     * 业务逻辑：
     * 1. 参数校验
     * 2. 查询商品信息
     * 3. 计算总价
     * 4. 扣库存
     * 5. 订单入库
     *
     * @return 调用结果
     */
    @PostMapping("/create")
    public ResultVO createOrder(@Valid OrderRequestDTO requestDTO, BindingResult bindingResult) {
        ResultVO result = new ResultVO();
        try {
            if (bindingResult.hasErrors()) {
                log.error("创建订单时参数不正确，requestDTO = {}", JSON.toJSON(requestDTO));
                throw new OrderException(ResultEnum.PARAM_VALIDATE_FAILED);
            }
            OrderDTO orderDTO = OrderDTOHelper.convertFromOrderRequestDTO(requestDTO);
            if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
                log.error("创建订单时参数购物车为空");
                throw new OrderException(ResultEnum.PARAM_VALIDATE_FAILED);
            }

            OrderDTO resultDTO = orderService.createOrder(orderDTO);

            Map<String, String> resultMap = new HashMap<>(6);
            resultMap.put("orderId", resultDTO.getOrderId());
            return ResultVOUtil.success(resultMap);
        } catch (OrderException e) {
            log.error("调createOrder接口异常", e);
            result.setCode(e.getCode());
            result.setMsg(e.getMessage());
        } catch (Exception e) {
            log.error("调createOrder接口异常", e);
            result.setMsg(e.getMessage());
        }

        return result;
    }
}
