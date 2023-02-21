package com.centime.hellomicroservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/hello")
public class HelloWebController {
    private static final Logger logger = LoggerFactory.getLogger(HelloWebController.class);

    @GetMapping
    public String fetchHello() {
        logger.info("In get method of hello micro service, sending hello...");
        return "hello";
    }
}
