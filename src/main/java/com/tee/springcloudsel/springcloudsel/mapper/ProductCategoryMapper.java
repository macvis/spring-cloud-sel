package com.tee.springcloudsel.springcloudsel.mapper;

import com.tee.springcloudsel.springcloudsel.domain.ProductCategory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 表TB_PRODUCT_CATEGORY的mapper类
 *
 * @author youchao.wen
 * @date 2018/9/27.
 */
@Component
public interface ProductCategoryMapper {

    List<ProductCategory> selectAll();
}
