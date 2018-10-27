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

    List<ProductInfo> selectAll();
}
