package com.nla.forum.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class AnswerVO {

    private Integer id;//评论的answerId
    private String content;//评论的内容
    private Integer useful;//点赞
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createtime;//评论的创建时间
    private Integer topicId;//评论对应的话题的topicId
    private Integer userId;//该话题的用户的userId
    private String username;
    private Integer score; //老师打分
    private Boolean judge;  //赞没赞

    public Boolean getJudge() {
        return judge;
    }

    public void setJudge(Boolean judge) {
        this.judge = judge;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUseful() {
        return useful;
    }

    public void setUseful(Integer useful) {
        this.useful = useful;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
