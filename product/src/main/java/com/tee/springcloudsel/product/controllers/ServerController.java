package com.tee.springcloudsel.product.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author youchao.wen
 * @date 2018/10/30.
 */
@RestController
@RequestMapping("/server/")
public class ServerController {
    @PostMapping("/message")
    public String message(){
        return "this is a product message";
    }
}
