package com.tee.springcloudsel.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author youchao.wen
 * @date 2018/11/10.
 */
@FeignClient(name = "spring-cloud-product-sel-product-service")
public interface ProductClient {

    /**
     * 获取product的message
     * @return message
     */
    @PostMapping("/server/message")
    String productMessage();
}
