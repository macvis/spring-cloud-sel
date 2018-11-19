package com.tee.springcloudsel.product.service.impl;

import com.tee.springcloudsel.product.domain.ProductInfo;
import com.tee.springcloudsel.product.dto.ProductCartDTO;
import com.tee.springcloudsel.product.enums.ResultEnum;
import com.tee.springcloudsel.product.exception.ProductException;
import com.tee.springcloudsel.product.mapper.ProductInfoMapper;
import com.tee.springcloudsel.product.service.ProductInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author youchao.wen
 * @date 2018/10/8.
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> listAll() {
        return productInfoMapper.selectAll();
    }

    @Override
    public List<ProductInfo> listByProductIdList(List<String> productIdList) {
        if (CollectionUtils.isEmpty(productIdList)) {
            return null;
        }

        return productInfoMapper.selectByIdList(productIdList);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void decreaseStock(List<ProductCartDTO> cartDTOList) throws Exception {
        if (CollectionUtils.isEmpty(cartDTOList)) {
            return;
        }

        for(ProductCartDTO cartDTO : cartDTOList){
            if(StringUtils.isBlank(cartDTO.getProductId())){
                continue;
            }

            if(productInfoMapper.countById(cartDTO.getProductId()) <= 0){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            ProductInfo productInfo = productInfoMapper.selectById(cartDTO.getProductId());
            int resultStock = productInfo.getProductStock() - cartDTO.getCount();
            if(resultStock <= 0){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_UNAVAILABLE);
            }

            productInfo.setProductStock(resultStock);
            productInfoMapper.updateProductInfo(productInfo);
        }
    }
}
