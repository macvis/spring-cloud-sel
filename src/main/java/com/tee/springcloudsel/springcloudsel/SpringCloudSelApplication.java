package com.tee.springcloudsel.springcloudsel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.tee.springcloudsel.springcloudsel.mapper")
public class SpringCloudSelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudSelApplication.class, args);
    }
}
