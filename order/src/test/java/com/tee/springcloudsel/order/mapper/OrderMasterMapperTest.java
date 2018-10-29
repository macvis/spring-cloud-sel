package com.tee.springcloudsel.order.mapper;
import com.alibaba.fastjson.JSON;
import com.tee.springcloudsel.order.constant.OrderStatus;
import com.tee.springcloudsel.order.constant.PayStatus;
import com.tee.springcloudsel.order.domain.OrderMaster;
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
 * com.tee.springcloudsel.springcloudsel.mapper.OrderMasterMapper
 *      的单元测试类
 *
 * @author youchao.wen
 * @date 2018/9/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Rollback
@Log4j2
public class OrderMasterMapperTest {

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    private String orderId = "";
    @Before
    public void init() {
        orderId = "2018102700001";
    }

    @Test
    public void testSelectAll() {
        List<OrderMaster> list = orderMasterMapper.selectAll();
        System.out.println("list -> " + list);
        Assert.assertNotNull(list);
    }

    @Test
    public void testSave(){
        OrderMaster om = new OrderMaster();
        om.setOrderId(orderId);
        om.setBuyerName("Terrence Wen");
        om.setBuyerPhone("18012341234");
        om.setBuyerAddress("USA Los Angeles");
        om.setBuyerOpenid("WX2018102700CA34GF");
        om.setOrderAmount(new BigDecimal("100"));
        om.setOrderStatus(OrderStatus.NEW.getValue());
        om.setPayStatus(PayStatus.PAID.getValue());
        om.setCreateTime(new Timestamp(new java.util.Date().getTime()));
        om.setUpdateTime(new Timestamp(new java.util.Date().getTime()));

        orderMasterMapper.saveOrderMaster(om);

        OrderMaster queried = orderMasterMapper.selectById(orderId);
        log.info("从数据库中查询的数据 -> {}", JSON.toJSONString(queried));
        Assert.assertNotNull(queried);
    }
}
