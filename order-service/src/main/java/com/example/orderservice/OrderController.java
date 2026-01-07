package com.example.orderservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @GetMapping("/orders")
    public List<String> orders() {
        return List.of("order-1", "order-2");
    }
}
