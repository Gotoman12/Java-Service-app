package com.example.uiservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class UiController {

    private final RestTemplate restTemplate;

    @Value("${user.service.base-url:http://localhost:8081}")
    private String userServiceBaseUrl;

    public UiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<?> users = Arrays.asList(restTemplate.getForObject(userServiceBaseUrl + "/users", Object[].class));
        model.addAttribute("users", users);
        model.addAttribute("userForm", new UserForm());
        return "index";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute UserForm userForm) {
        Map<String, String> body = Map.of(
                "name", userForm.getName(),
                "email", userForm.getEmail()
        );
        restTemplate.postForObject(userServiceBaseUrl + "/users", body, Object.class);
        return "redirect:/";
    }
}
