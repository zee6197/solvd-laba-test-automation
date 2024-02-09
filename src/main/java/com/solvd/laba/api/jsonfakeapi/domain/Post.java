package com.solvd.laba.api.jsonfakeapi.domain;

public class Post {

    private Integer id;
    private Integer score;
    private String title;
    private String body;

    
    public Post() {
    }

    public Post(Integer userId, String title, String body) {
        this.score = userId;
        this.title = title;
        this.body = body;
    }


    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    @Override
    public String toString() {
        return "Post{" +
                "userId=" + score +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
