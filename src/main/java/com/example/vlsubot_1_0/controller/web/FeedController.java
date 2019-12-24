package com.example.vlsubot_1_0.controller.web;

import com.example.vlsubot_1_0.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeedController {

    private FeedService feedService;

    @Autowired
    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @GetMapping("/feed")
    public String getFeed(Model model) {
        model.addAttribute("items", feedService.getAllForWeb());
        return "feed";
    }

}
