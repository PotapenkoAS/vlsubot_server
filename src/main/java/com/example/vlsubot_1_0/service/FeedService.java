package com.example.vlsubot_1_0.service;

import com.example.vlsubot_1_0.model.entity.FeedItem;
import com.example.vlsubot_1_0.model.repository.FeedItemRepository;
import org.intellij.lang.annotations.JdkConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FeedService {

    private FeedItemRepository feedItemRepository;

    @Autowired
    public FeedService(FeedItemRepository feedItemRepository) {
        this.feedItemRepository = feedItemRepository;
    }

    public ArrayList<FeedItem> getAll(){
        return feedItemRepository.findAll();
    }
}
