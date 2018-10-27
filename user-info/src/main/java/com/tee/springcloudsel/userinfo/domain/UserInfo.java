package com.tee.springcloudsel.userinfo.domain;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户信息
 *
 * @author youchao.wen
 * @date 2018/9/15.
 */
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 2688011612072755345L;

    /**
     * 主键
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 角色
     */
    private String role;

    /**
     * 主键
     */
    private Timestamp createTime;

    /**
     * 主键
     */
    private Timestamp updateTime;
}
