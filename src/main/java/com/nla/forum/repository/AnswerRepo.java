package com.nla.forum.repository;

import com.nla.forum.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface AnswerRepo extends JpaRepository<Answer,Integer> {
    Answer findAnswerById(Integer id);
    List<Answer> findAnswersByTopicId(Integer id);
    List<Answer> findAnswersByUserId(Integer userId);

    @Modifying
    @Transactional
    @Query(value = "update answer set score= ?1 where id= ?2", nativeQuery = true)
    int update(Integer score,Integer userId);
}
