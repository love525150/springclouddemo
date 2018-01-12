package org.allen.springcloudfeign.controller;

import org.allen.springcloudfeign.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("feign")
    public String feign() {
        return testService.testClientOne();
    }
}
