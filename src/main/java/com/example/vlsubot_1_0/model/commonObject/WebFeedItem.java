package com.example.vlsubot_1_0.model.commonObject;

import java.sql.Timestamp;

public class WebFeedItem {
    private int id;
    private String title;
    private String text;
    private String dateTime;
    private String image;
    private String url;

    public WebFeedItem(int id, String title, String text, String dateTime, String image, String url) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.dateTime = dateTime;
        this.image = image;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
