package com.example.vlsubot_1_0.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String getRegistration() {
        return "login/registration";
    }

    @PostMapping("/registration")
    public String postRegistration() {
        return "feed";
    }
}
