package com.example.vlsubot_1_0.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getBaseHome(){
        return "redirect:/feed";
    }

    @GetMapping("/feed")
    public String getFeed(){
        return "home";
    }
}
