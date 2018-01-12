package org.allen.controller;

import org.allen.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/hi")
    public String hi(){
        return testService.testClientService();
    }

}