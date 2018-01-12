package org.allen.springcloudfeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("a-bootiful-client")
public interface TestService {
    @RequestMapping(value = "test/name", method = RequestMethod.GET)
    String testClientOne();

}
