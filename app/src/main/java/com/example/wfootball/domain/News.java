package com.example.wfootball.domain;

public class News {

    private String title;

    public News(String title, String description) {
        this.title = title;
        this.description = description;
    }

    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
