package com.tee.springcloudlearning.productclient.dto;

import lombok.Data;

/**
 * @author youchao.wen
 * @date 2018/11/17.
 */
@Data
public class ProductCartDTO {
    private String productId;

    private Integer count;

    public ProductCartDTO(String productId, Integer count){
        this.productId = productId;
        this.count = count;
    }

    public ProductCartDTO(){}
}
