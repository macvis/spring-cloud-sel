package com.tee.springcloudsel.product.mapper;

import com.alibaba.fastjson.JSON;
import com.tee.springcloudsel.product.domain.ProductInfo;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * com.tee.springcloudsel.springcloudsel.mapper.ProductInfoMapper
 *      的单元测试类
 *
 * @author youchao.wen
 * @date 2018/9/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Log4j2
public class ProductInfoMapperTest {
    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Before
    public void init() {

    }

    @Test
    public void testSelectAll() {
        List<ProductInfo> list = productInfoMapper.selectAll();
        System.out.println("list -> " + list);
        Assert.assertNotNull(list);
    }

    @Test
    public void testSelectByIdList(){
        List<String> idList = new ArrayList<>();
        idList.add("157875227953464068");
        idList.add("164103465734242707");

        List<ProductInfo> list = productInfoMapper.selectByIdList(idList);
        log.info(JSON.toJSONString(list));
        Assert.assertTrue(list.size() > 0);
    }
}
