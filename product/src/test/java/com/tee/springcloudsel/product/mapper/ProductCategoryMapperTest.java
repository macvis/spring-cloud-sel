package com.tee.springcloudsel.product.mapper;

import com.tee.springcloudsel.product.domain.ProductCategory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * com.tee.springcloudsel.springcloudsel.mapper.ProductCategoryMapper
 *      的单元测试类
 *
 * @author youchao.wen
 * @date 2018/9/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Before
    public void init() {

    }

    @Test
    public void testSelectAll() {
        List<ProductCategory> list = productCategoryMapper.selectAll();
        System.out.println("list -> " + list);
        Assert.assertNotNull(list);
    }
}
