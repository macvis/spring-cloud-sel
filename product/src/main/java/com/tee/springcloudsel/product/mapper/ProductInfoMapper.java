package com.tee.springcloudsel.product.mapper;

import com.tee.springcloudsel.product.domain.ProductInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 表PROPDUCT_INFO的mapper类
 *
 * @author youchao.wen
 * @date 2018/9/27.
 */
@Component
public interface ProductInfoMapper {

    /**
     * 全表查询
     * @return
     */
    List<ProductInfo> selectAll();

    /**
     * 使用id list查询这些id的数据
     * @param productIdList id list
     * @return 商品信息
     */
    List<ProductInfo> selectByIdList(List<String> productIdList);
}
