package com.cgi.demo.search.service;

public class YoutubeModel {

    String url;

    String title;

    YoutubeModel(){}

    YoutubeModel(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "YoutubeModel{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
