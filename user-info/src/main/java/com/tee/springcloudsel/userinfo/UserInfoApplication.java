package com.tee.springcloudsel.userinfo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.tee.springcloudsel.userinfo.mapper")
public class UserInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserInfoApplication.class, args);
    }
}
