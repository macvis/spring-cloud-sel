package com.tee.springcloudsel.springcloudsel.controllers;

import com.tee.springcloudsel.springcloudsel.domain.ProductInfo;
import com.tee.springcloudsel.springcloudsel.dto.ProductVO;
import com.tee.springcloudsel.springcloudsel.dto.ResultVO;
import com.tee.springcloudsel.springcloudsel.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping(value = "/queryAll")
    @ResponseBody
    public ResultVO<ProductVO> queryAll() {
        ProductVO productVO = new ProductVO();
        List<ProductInfo> list = productInfoService.listAll();
        ResultVO resultVO = new ResultVO(productVO);

        return resultVO;
    }
}
