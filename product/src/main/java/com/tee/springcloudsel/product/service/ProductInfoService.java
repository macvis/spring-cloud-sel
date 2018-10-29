package com.tee.springcloudsel.product.service;

import com.tee.springcloudsel.product.domain.ProductInfo;

import java.util.List;

/**
 * @author youchao.wen
 * @date 2018/10/8.
 */
public interface ProductInfoService {
    /**
     * 查询所有的productInfo
     * @return
     */
    List<ProductInfo> listAll();
}