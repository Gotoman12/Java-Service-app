package com.example.inventoryservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController {

    @GetMapping("/inventory")
    public List<String> inventory() {
        return List.of("item-1", "item-2");
    }
}
