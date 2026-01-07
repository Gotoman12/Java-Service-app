package com.example.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class GatewayController {

    private final RestTemplate restTemplate;

    public GatewayController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/api/health")
    public String health() {
        return "API Gateway is up";
    }

    @GetMapping("/api/users")
    public List<?> users() {
        return restTemplate.getForObject("http://localhost:8081/users", List.class);
    }
}
