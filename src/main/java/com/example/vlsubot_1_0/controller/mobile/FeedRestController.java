package com.example.vlsubot_1_0.controller.mobile;

import com.example.vlsubot_1_0.model.entity.FeedItem;
import com.example.vlsubot_1_0.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/rest")
public class FeedRestController {

    private FeedService feedService;

    @Autowired
    public FeedRestController(FeedService feedService) {
        this.feedService = feedService;
    }

    @GetMapping("/feed")
    public ArrayList<FeedItem> getFeed() {
        return feedService.getAll();
    }
}
