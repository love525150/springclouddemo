package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("consume")
    public String consume() {
        List<ServiceInstance> instances = discoveryClient.getInstances("a-bootiful-client");
        String result = "";
        if (!CollectionUtils.isEmpty(instances)) {
            ServiceInstance serviceInstance = instances.iterator().next();
            String host = serviceInstance.getHost();
            int port = serviceInstance.getPort();
            result = restTemplate.getForObject("http://" + host + ":" + port + "/test/name", String.class);
        }
        return "consume from " + result;
    }
}
