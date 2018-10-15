package com.tee.springcloudsel.springcloudsel.VO;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author youchao.wen
 * @date 2018/10/8.
 */
@Data
public class ProductInfoVO {

    private String id;

    private String name;

    private BigDecimal price;

    private String description;
}
