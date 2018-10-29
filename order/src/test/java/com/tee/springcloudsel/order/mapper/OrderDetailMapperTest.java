package com.tee.springcloudsel.order.mapper;
import com.tee.springcloudsel.order.domain.OrderDetail;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author youchao.wen
 * @date 2018/9/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Rollback
@Log4j2
public class OrderDetailMapperTest {
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    private String orderDetailId;
    @Before
    public void init() {

    }

    @Test
    public void testSelectAll() {
        List<OrderDetail> list = orderDetailMapper.selectAll();
        System.out.println("list -> " + list);
        Assert.assertNotNull(list);
    }

    @Test
    public void testSave() {
        OrderDetail od = new OrderDetail();
        od.setDetailId("");
        od.setOrderId("");
        od.setProductId("");
        od.setProductName("");
        od.setProductPrice(new BigDecimal("0"));
        od.setProductQuantity(0);
        od.setProductIcon("");
        od.setCreateTime(new Timestamp(new java.util.Date().getTime()));
        od.setUpdateTime(new Timestamp(new java.util.Date().getTime()));


    }
}
