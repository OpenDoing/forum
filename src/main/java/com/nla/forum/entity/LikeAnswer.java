package com.nla.forum.entity;

import javax.persistence.*;

@Entity
@Table(name = "likeanswer")
public class LikeAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    private Integer useful;

    @Override
    public String toString() {
        return "LikeAnswer{" +
                "id=" + id +
                ", userId=" + userId +
                ", useful=" + useful +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUseful() {
        return useful;
    }

    public void setUseful(Integer useful) {
        this.useful = useful;
    }
}
