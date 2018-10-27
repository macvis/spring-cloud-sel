package com.tee.springcloudsel.product.domain;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 商品类别，domain
 *
 * @author youchao.wen
 * @date 2018/9/15.
 */
@Data
public class ProductCategory implements Serializable {
    private static final long serialVersionUID = -7355281021019220837L;

    /**
     * 主键
     */
    private String categoryId;

    /**
     * 类目名字
     */
    private String categoryName;

    /**
     * 类目编号
     */
    private Integer categoryType;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 修改时间
     */
    private String updateTime;
}
