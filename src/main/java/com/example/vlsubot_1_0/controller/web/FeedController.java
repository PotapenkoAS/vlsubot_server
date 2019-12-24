package com.example.vlsubot_1_0.controller.web;

import com.example.vlsubot_1_0.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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


    @GetMapping("/edit/{itemId}")
    private String getEditItem(@PathVariable String itemId, Model model) {
        model.addAttribute("item", feedService.getById(Integer.parseInt(itemId)));
        return "templates/edit.html";
    }
}
