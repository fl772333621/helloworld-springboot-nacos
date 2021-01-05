package com.mfanw.helloworld.nacos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello controller
 *
 * @author mengwei
 */
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello/{content}")
    public String test(@PathVariable String content) {
        LOGGER.warn("接收到请求：" + content);
        return "Hello Nacos :" + content;
    }
}
