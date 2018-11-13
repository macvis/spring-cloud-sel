package com.tee.springcloudsel.product.service;

import com.alibaba.fastjson.JSON;
import com.tee.springcloudsel.product.ProductApplicationTests;
import com.tee.springcloudsel.product.domain.ProductInfo;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * @author youchao.wen
 * @date 2018/10/8.
 */
@Component
@Log4j2
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

    @Test
    public void testListByProductId(){
        List<String> idList = new ArrayList<>();
        idList.add("157875227953464068");
        idList.add("164103465734242707");

        List<ProductInfo> list = productInfoService.listByProductIdList(idList);
        log.info(JSON.toJSONString(list));

        Assert.assertTrue(list.size() > 0);
    }

}
