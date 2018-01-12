package org.allen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService {

    @Autowired
    RestTemplate restTemplate;

    public String testClientService() {
        return restTemplate.getForObject("http://a-bootiful-client/test/name",String.class);
    }

}
