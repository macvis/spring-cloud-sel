package com.tee.springcloudsel.product.controllers;

import com.tee.springcloudsel.product.VO.ProductVO;
import com.tee.springcloudsel.product.domain.ProductInfo;
import com.tee.springcloudsel.product.service.ProductCategoryService;
import com.tee.springcloudsel.product.service.ProductInfoService;
import com.tee.springcloudsel.springcloudsel.dto.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品查询的controller
 *
 * @author youchao.wen
 * @date 2018/9/15.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService categoryService;

    @PostMapping(value = "/queryAll")
    @ResponseBody
    public ResultVO<ProductVO> queryAll() {
        ProductVO productVO = new ProductVO();
        //1. 查询所有在架商品
        List<ProductInfo> list = productInfoService.listAll();
        //2. 获取类目type列表
        List<Integer> catgoryTypeList =
                list.stream().map(ProductInfo :: getCategoryType)
                .collect(Collectors.toList());
        //3. 从数据库查询类目



        return new ResultVO(productVO);

    }

    @RequestMapping(value = "/queryOne")
    @ResponseBody
    public ResultVO<ProductVO> queryById(){
        return null;
    }
}
