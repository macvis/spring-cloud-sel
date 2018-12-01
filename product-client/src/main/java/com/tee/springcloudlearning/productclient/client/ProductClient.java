package com.tee.springcloudlearning.productclient.client;

import com.tee.springcloudlearning.productclient.dto.ProductCartDTO;
import com.tee.springcloudlearning.productclient.dto.ProductInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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

    /**
     * 根据商品id列表获取商品列表
     * @param productIdList 商品id列表
     * @return 商品列表
     */
    @PostMapping("/product/listForOrder")
    List<ProductInfoDTO> listForOrder(List<String> productIdList);

    /**
     * 减少库存的接口
     * @param cartDTOList 购物车商品列表
     */
    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<ProductCartDTO> cartDTOList);
}
