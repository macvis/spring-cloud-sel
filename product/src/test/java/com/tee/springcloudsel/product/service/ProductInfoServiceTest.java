package com.tee.springcloudsel.product.service;

import com.tee.springcloudsel.product.ProductApplicationTests;
import com.tee.springcloudsel.product.domain.ProductInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author youchao.wen
 * @date 2018/10/8.
 */
@Component
public class ProductInfoServiceTest extends ProductApplicationTests {
    @Autowired
    private ProductInfoService productInfoService;

    @Before
    public void init() {

    }

    @Test
    public void testSelectAll() {
        List<ProductInfo> list = productInfoService.listAll();
        System.out.println("list -> " + list);
        Assert.assertNotNull(list);
    }
}
