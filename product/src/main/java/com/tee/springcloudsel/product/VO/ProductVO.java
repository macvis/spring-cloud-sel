package com.tee.springcloudsel.product.VO;

import lombok.Data;

import java.util.List;

/**
 * @author youchao.wen
 * @date 2018/10/8.
 */
@Data
public class ProductVO {

    private String name;

    private Integer type;

    private List<ProductInfoVO> foods;
}
