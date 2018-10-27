package com.tee.springcloudsel.product.service;

import com.tee.springcloudsel.product.domain.ProductCategory;

import java.util.List;

/**
 * @author youchao.wen
 * @date 2018/10/8.
 */
public interface ProductCategoryService {
    /**
     * 查询所有数据
     * @return
     */
    List<ProductCategory> listAll();
}
