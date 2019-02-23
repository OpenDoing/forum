package com.nla.forum.repository;

import com.nla.forum.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TopicRepo extends JpaRepository<Topic,Integer> {
    List<Topic> findAllByCategory(String category);
    Topic findTopicById(Integer id);
    List<Topic> findTopicsByUserId(Integer userId);

    @Modifying
    @Transactional
    @Query(value = "update topic set title= ?1 where id= ?2", nativeQuery = true)
    int updateTitle(String title, Integer id);
}
