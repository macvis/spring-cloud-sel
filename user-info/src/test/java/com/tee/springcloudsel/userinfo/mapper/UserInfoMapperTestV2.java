package com.tee.springcloudsel.userinfo.mapper;

import com.tee.springcloudsel.userinfo.domain.UserInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * com.tee.springcloudsel.springcloudsel.mapper.UserInfoMapper
 *      的单元测试类
 *      v2代表版本，不知为何不加v2时引起本地文件冲突
 *
 * @author youchao.wen
 * @date 2018/9/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserInfoMapperTestV2 {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Before
    public void init() {

    }

    @Test
    public void testSelectAll() {
        List<UserInfo> list = userInfoMapper.selectAll();
        System.out.println("list -> " + list);
        Assert.assertNotNull(list);
    }
}
