package com.tee.springcloudsel.order.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author youchao.wen
 * @date 2018/11/12.
 */
@Data
public class ProductInfoDTO implements Serializable {
    private static final long serialVersionUID = 7694480955554274326L;

    /**
     * 主键
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 描述
     */
    private String productDescription;

    /**
     * 小图
     */
    private String productIcon;

    /**
     * 商品状态,0正常1下架
     */
    private String productStatus;

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
    private Timestamp updateTime;
}
