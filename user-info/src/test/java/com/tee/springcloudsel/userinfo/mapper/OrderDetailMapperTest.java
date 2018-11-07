package com.tee.springcloudsel.product.mapper;

import com.tee.springcloudsel.springcloudsel.domain.OrderDetail;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author youchao.wen
 * @date 2018/9/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderDetailMapperTest {
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Before
    public void init() {

    }

    @Test
    public void testSelectAll() {
        List<OrderDetail> list = orderDetailMapper.selectAll();
        System.out.println("list -> " + list);
        Assert.assertNotNull(list);
    }
}
