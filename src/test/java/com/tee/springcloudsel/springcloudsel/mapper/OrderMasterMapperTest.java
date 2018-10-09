package com.tee.springcloudsel.springcloudsel.mapper;

import com.tee.springcloudsel.springcloudsel.domain.OrderMaster;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
public class OrderMasterMapperTest {

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Before
    public void init() {

    }

    @Test
    public void testSelectAll() {
        List<OrderMaster> list = orderMasterMapper.selectAll();
        System.out.println("list -> " + list);
        Assert.assertNotNull(list);
    }
}
