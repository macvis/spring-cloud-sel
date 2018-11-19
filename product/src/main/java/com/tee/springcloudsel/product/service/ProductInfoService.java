package com.tee.springcloudsel.product.service;

import com.tee.springcloudsel.product.domain.ProductInfo;
import com.tee.springcloudsel.product.dto.ProductCartDTO;

import java.util.List;

/**
 * @author youchao.wen
 * @date 2018/10/8.
 */
public interface ProductInfoService {
    /**
     * 查询所有的productInfo
     * @return
     */
    List<ProductInfo> listAll();

    /**
     * 根据商品id list查询根据商品list
     * @param productIdList 根据商品id list
     * @return 商品list
     */
    List<ProductInfo> listByProductIdList(List<String> productIdList);

    /**
     * 扣库存
     * @param cartDTOList 购物车对象列表
     */
    void decreaseStock(List<ProductCartDTO> cartDTOList) throws Exception;
}
