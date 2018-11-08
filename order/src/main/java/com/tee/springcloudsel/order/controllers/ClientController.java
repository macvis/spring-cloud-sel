package com.tee.springcloudsel.order.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/getProductMessage")
    public String getProductMessage(){
        //1. 使用restTemplate的第一种方式
        //缺点：url写死，不灵活
        RestTemplate restTemplate1 = new RestTemplate();
        String result1 = restTemplate1.postForObject("http://127.0.0.1:8080/server/message",null, String.class);
        log.info("result1 -> {}", result1);

        //2. 第二种方式，可以配置负载均衡
        //缺点，利用loadBalanceClient拼接url，在使用retTemplate，繁琐
        ServiceInstance serviceInstance = loadBalancerClient.choose("SPRING-CLOUD-PRODUCT-SEL-PRODUCT-SERVICE");
        String url = ("http://").concat(serviceInstance.getHost()).concat(":").concat(serviceInstance.getPort() + "").concat("/server/message");
        RestTemplate restTemplate2 = new RestTemplate();
        String result2 = restTemplate2.postForObject(url,null, String.class);
        log.info("result2 -> {}", result2);

        //3. 使用loadBalanced注解，可在restTemplate里使用应用名来直接调用
        String appName = "SPRING-CLOUD-PRODUCT-SEL-PRODUCT-SERVICE";
        String result3 = restTemplate.postForObject("http://" + appName + "/server/message", null, String.class);
        log.info("result3 -> {}", result3);
        return result3;
    }
}
