package com.tee.springcloudsel.product.dto;

import lombok.Data;

/**
 * @author youchao.wen
 * @date 2018/11/17.
 */
@Data
public class ProductCartDTO {
    private String productId;

    private Integer count;
}
