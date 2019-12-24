package com.example.vlsubot_1_0.model.repository;

import com.example.vlsubot_1_0.model.entity.FeedItem;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface FeedItemRepository extends CrudRepository<FeedItem, Integer> {
    ArrayList<FeedItem> findAll();

    FeedItem findById(int id);
}
