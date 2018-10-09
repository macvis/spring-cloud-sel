package com.tee.springcloudsel.springcloudsel.service;

import com.tee.springcloudsel.springcloudsel.SpringCloudSelApplicationTests;
import com.tee.springcloudsel.springcloudsel.domain.ProductInfo;
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
public class ProductInfoServiceTest extends SpringCloudSelApplicationTests {
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
