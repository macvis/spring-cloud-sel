package com.tee.springcloudsel.order.controllers;

import com.tee.springcloudsel.springcloudsel.dto.ResultVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author youchao.wen
 * @date 2018/10/21.
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

//    private

    /**
     * 创建订单
     * @return
     */
    @PostMapping("/create")
    public ResultVO<List<String>> createOrder() {
        return null;
    }
}
