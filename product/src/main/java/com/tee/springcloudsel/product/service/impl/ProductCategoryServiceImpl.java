package com.tee.springcloudsel.product.service.impl;

import com.tee.springcloudsel.product.domain.ProductCategory;
import com.tee.springcloudsel.product.mapper.ProductCategoryMapper;
import com.tee.springcloudsel.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author youchao.wen
 * @date 2018/10/8.
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper mapper;

    @Override
    public List<ProductCategory> listAll() {
        return mapper.selectAll();
    }
}
