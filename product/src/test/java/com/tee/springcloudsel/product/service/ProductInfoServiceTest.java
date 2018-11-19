package com.tee.springcloudsel.product.service;

import com.alibaba.fastjson.JSON;
import com.tee.springcloudsel.product.ProductApplicationTests;
import com.tee.springcloudsel.product.domain.ProductInfo;
import com.tee.springcloudsel.product.dto.ProductCartDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * @author youchao.wen
 * @date 2018/10/8.
 */
@Component
@Log4j2
public class ProductInfoServiceTest extends ProductApplicationTests {
    @Autowired
    private ProductInfoService productInfoService;

    @Before
    public void init() {

    }

    @Test
    public void testSelectAll() {
        List<ProductInfo> list = productInfoService.listAll();
        System.out.println("list -> " + list);
        Assert.assertNotNull(list);
    }

    @Test
    public void testListByProductId(){
        List<String> idList = new ArrayList<>();
        idList.add("157875227953464068");
        idList.add("164103465734242707");

        List<ProductInfo> list = productInfoService.listByProductIdList(idList);
        log.info(JSON.toJSONString(list));

        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void testDecreaseStock(){
        String productId = "164103465734242707";
        int count1 = 10;
        ProductCartDTO cartDTO1 = new ProductCartDTO();
        cartDTO1.setProductId(productId);
        cartDTO1.setCount(count1);

        String productId2 = "157875227953464068";
        int count2 = 12;
        ProductCartDTO cartDTO2 = new ProductCartDTO();
        cartDTO2.setProductId(productId2);
        cartDTO2.setCount(count2);

        List<ProductCartDTO> productCartDTOList = new ArrayList<>();
        productCartDTOList.add(cartDTO1);
        productCartDTOList.add(cartDTO2);

        try{
            productInfoService.decreaseStock(productCartDTOList);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
