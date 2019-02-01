package com.nla.forum.repository;

import com.nla.forum.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepo extends JpaRepository<Answer,Integer> {
    Answer findAnswerById(Integer id);

}
