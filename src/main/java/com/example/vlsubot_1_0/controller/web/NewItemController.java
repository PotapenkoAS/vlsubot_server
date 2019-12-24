package com.example.vlsubot_1_0.controller.web;

import com.example.vlsubot_1_0.model.entity.FeedItem;
import com.example.vlsubot_1_0.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class NewItemController {

    private FeedService feedService;

    @Autowired
    public NewItemController(FeedService feedService) {
        this.feedService = feedService;
    }

    @GetMapping("/new_item")
    public String getNewItem() {
        return "new_item";
    }

    @PostMapping("/new_item")
    public String postNewItem(@RequestParam("image") MultipartFile image, String title, String text, String url) {
        try {
            feedService.save(new FeedItem(null, title, text, new Timestamp(new Date().getTime()), image.getBytes(), url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/feed";
    }
}
