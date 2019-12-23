package com.example.vlsubot_1_0.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "feed_item", schema = "vlsudb")
public class FeedItem {
    private int id;
    private String title;
    private String text;
    private Timestamp dateTime;
    private byte[] image;
    private String url;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "date_time")
    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp datetime) {
        this.dateTime = datetime;
    }

    @Basic
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedItem feedItem = (FeedItem) o;

        if (id != feedItem.id) return false;
        if (!Objects.equals(title, feedItem.title)) return false;
        if (!Objects.equals(text, feedItem.text)) return false;
        if (!Objects.equals(dateTime, feedItem.dateTime)) return false;
        return Arrays.equals(image, feedItem.image);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
