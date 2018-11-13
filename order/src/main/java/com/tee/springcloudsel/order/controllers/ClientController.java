package com.tee.springcloudsel.order.controllers;

import com.alibaba.fastjson.JSON;
import com.tee.springcloudsel.order.client.ProductClient;
import com.tee.springcloudsel.order.dto.ProductInfoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author youchao.wen
 * @date 2018/10/30.
 */
@RestController
@RequestMapping("/client")
@Log4j2
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**  restTemplate上可以使用@LoadBalanced注解*/
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @PostMapping("/getProductMessage")
    public String getProductMessage(){
        //1. 使用restTemplate的第一种方式
        //缺点：url写死，不灵活
//        RestTemplate restTemplate1 = new RestTemplate();
//        String result1 = restTemplate1.postForObject("http://127.0.0.1:8080/server/message",null, String.class);
//        log.info("result1 -> {}", result1);

        //2. 第二种方式，可以配置负载均衡
        //缺点，利用loadBalanceClient拼接url，在使用retTemplate，繁琐
//        ServiceInstance serviceInstance = loadBalancerClient.choose("SPRING-CLOUD-PRODUCT-SEL-PRODUCT-SERVICE");
//        String url = ("http://").concat(serviceInstance.getHost()).concat(":").concat(serviceInstance.getPort() + "").concat("/server/message");
//        RestTemplate restTemplate2 = new RestTemplate();
//        String result2 = restTemplate2.postForObject(url,null, String.class);
//        log.info("result2 -> {}", result2);

        //3. 使用loadBalanced注解，可在restTemplate里使用应用名来直接调用
//        String appName = "SPRING-CLOUD-PRODUCT-SEL-PRODUCT-SERVICE";
//        String result3 = restTemplate.postForObject("http://" + appName + "/server/message", null, String.class);
//        log.info("result3 -> {}", result3);
//        return result3;

        //4. 使用feign client，相当于将接口调用方变成一个可以配置的bean
        //然后使用bean方法调用
        //个人理解：调用方式等价于dubbo的rpc过程，所以是伪rpc的方式
        String response = productClient.productMessage();
        log.info("result 4, feign client -> {}", response);

        return response;
    }

    @PostMapping("/getProductListByIds")
    @ResponseBody
    public List<ProductInfoDTO> getProductListByIds(){
        List<String> idList = new ArrayList<>();
        idList.add("157875227953464068");
        idList.add("164103465734242707");
        List<ProductInfoDTO> resultList = productClient.listForOrder(idList);
        log.info("查询结果 -> {}", JSON.toJSONString(resultList));

        return resultList;
    }

}
