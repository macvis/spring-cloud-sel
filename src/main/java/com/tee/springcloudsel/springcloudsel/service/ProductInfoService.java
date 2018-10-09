package com.tee.springcloudsel.springcloudsel.service;

import com.tee.springcloudsel.springcloudsel.domain.ProductInfo;

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
