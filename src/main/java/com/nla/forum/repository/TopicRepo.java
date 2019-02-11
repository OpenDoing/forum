package com.nla.forum.repository;

import com.nla.forum.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepo extends JpaRepository<Topic,Integer> {
    List<Topic> findAllByCategory(String category);
    Topic findTopicById(Integer id);
    List<Topic> findTopicsByUserId(Integer userId);

}
