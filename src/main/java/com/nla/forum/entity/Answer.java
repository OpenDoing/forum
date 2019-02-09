package com.nla.forum.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "answer")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//评论的answerId
	private String content;//评论的内容
//	private Integer useful;//点赞
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createtime;//评论的创建时间
//	private String code;//评论附加的代码
	@Column(name = "topic_id")
	private Integer topicId;//评论对应的话题的topicId
	@Column(name = "user_id")
	private Integer userId;//该话题的用户的userId

	private String username;
	private Integer score; //老师打分

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



	@Override
	public String toString() {
		return "Answer{" +
				"id=" + id +
				", content='" + content + '\'' +
				", createtime=" + createtime +
				", topicId=" + topicId +
				", userId=" + userId +
				", score=" + score +
				'}';
	}

	public LocalDateTime getCreatetime() {
		return createtime;
	}

	public void setCreatetime(LocalDateTime createtime) {
		this.createtime = createtime;
	}

    public String displayBeginning() {
        return (this.content.length() < 32) ? this.content.concat("...") : this.content.substring(0, 30).concat("...");
    }
}
