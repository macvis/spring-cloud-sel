package com.tee.springcloudsel.product.service.impl;

import com.tee.springcloudsel.product.domain.ProductInfo;
import com.tee.springcloudsel.product.mapper.ProductInfoMapper;
import com.tee.springcloudsel.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author youchao.wen
 * @date 2018/10/8.
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> listAll() {
        return productInfoMapper.selectAll();
    }
}
