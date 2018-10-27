package com.tee.springcloudsel.userinfo.mapper;

import com.tee.springcloudsel.userinfo.domain.UserInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 表USER_INFO的mybatis mapper类
 *
 * @author youchao.wen
 * @date 2018/9/27.
 */
@Component
public interface UserInfoMapper {

    /**
     * 查询所有
     * @return list
     */
    List<UserInfo> selectAll();
}
