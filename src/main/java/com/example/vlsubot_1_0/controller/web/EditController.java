package com.example.vlsubot_1_0.controller.web;

import com.example.vlsubot_1_0.model.entity.FeedItem;
import com.example.vlsubot_1_0.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Base64;

@Controller
public class EditController {

    private FeedService feedService;

    @Autowired
    public EditController(FeedService feedService) {
        this.feedService = feedService;
    }

    @GetMapping("/edit/{itemId}")
    public String getEdit(@PathVariable String itemId, Model model) {
        FeedItem item = feedService.getById(Integer.parseInt(itemId));
        model.addAttribute("item", item);
        model.addAttribute("image", Base64.getEncoder().encodeToString(item.getImage()));
        return "edit";
    }
}
