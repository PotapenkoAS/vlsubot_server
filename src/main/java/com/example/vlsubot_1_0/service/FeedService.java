package com.example.vlsubot_1_0.service;

import com.example.vlsubot_1_0.model.commonObject.WebFeedItem;
import com.example.vlsubot_1_0.model.entity.FeedItem;
import com.example.vlsubot_1_0.model.repository.FeedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FeedService {

    private FeedItemRepository feedItemRepository;

    @Autowired
    public FeedService(FeedItemRepository feedItemRepository) {
        this.feedItemRepository = feedItemRepository;
    }

    public ArrayList<FeedItem> getAll() {
        return feedItemRepository.findAll();
    }


    public ArrayList<WebFeedItem> getAllForWeb() {
        ArrayList<WebFeedItem> result = new ArrayList<>();
        ArrayList<FeedItem> list = feedItemRepository.findAllByOrderByDateTimeDesc();
        list.forEach(feedItem -> result.add(
                new WebFeedItem(
                        feedItem.getId(),
                        feedItem.getTitle(),
                        feedItem.getText(),
                        new SimpleDateFormat("dd MMM YY, HH:mm:ss", Locale.US).format(new Date(feedItem.getDateTime().getTime())),
                        (feedItem.getImage() != null) ? Base64.getEncoder().encodeToString(feedItem.getImage()) : "",
                        feedItem.getUrl())));
        return result;
    }

    public FeedItem getById(int id){
        return feedItemRepository.findById(id);
    }


}
