package com.nla.forum.entity;


import com.nla.forum.entity.combine.RecommandKey;

import javax.persistence.*;

@Entity
@Table(name = "recommend")
@IdClass(RecommandKey.class)
public class Recommend {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Id
    @Column(name = "topic_id")
    private Integer topicId;
    private Integer focus;//关注度

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getFocus() {
        return focus;
    }

    public void setFocus(Integer focus) {
        this.focus = focus;
    }

    @Override
    public String toString() {
        return "Recommend{" +
                ", userId=" + userId +
                ", topicId=" + topicId +
                ", focus=" + focus +
                '}';
    }
}
