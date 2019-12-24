package com.example.vlsubot_1_0.controller.web;

import com.example.vlsubot_1_0.model.commonObject.WebFeedItem;
import com.example.vlsubot_1_0.model.entity.FeedItem;
import com.example.vlsubot_1_0.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Date;

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

    @PostMapping("/edit/{itemId}")
    public String postEdit(@PathVariable String itemId, @RequestParam("image") MultipartFile image, String title, String text, String url) {
        try {
            feedService.save(new FeedItem(Integer.parseInt(itemId), title, text, new Timestamp(new Date().getTime()), image.getBytes(), url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/feed";
    }
}
