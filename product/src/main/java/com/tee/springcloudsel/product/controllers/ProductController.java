package com.tee.springcloudsel.product.controllers;

import com.tee.springcloudsel.product.VO.ProductVO;
import com.tee.springcloudsel.product.domain.ProductInfo;
import com.tee.springcloudsel.product.dto.ProductCartDTO;
import com.tee.springcloudsel.product.service.ProductCategoryService;
import com.tee.springcloudsel.product.service.ProductInfoService;
import com.tee.springcloudsel.springcloudsel.dto.ResultVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Log4j2
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
                list.stream().map(ProductInfo::getCategoryType)
                        .collect(Collectors.toList());
        //3. 从数据库查询类目


        return new ResultVO(productVO);

    }

    @RequestMapping(value = "/queryOne")
    @ResponseBody
    public ResultVO<ProductVO> queryById() {
        return null;
    }

    /**
     * 获取商品列表，给订单服务用
     * @param productIdList id列表
     * @return 商品列表
     */
    @PostMapping("/listForOrder")
    @ResponseBody
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList) {
        return productInfoService.listByProductIdList(productIdList);
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<ProductCartDTO> cartDTOList){
        try{
            productInfoService.decreaseStock(cartDTOList);
        }catch(Exception e){
            log.info("", e);
        }
    }
}
