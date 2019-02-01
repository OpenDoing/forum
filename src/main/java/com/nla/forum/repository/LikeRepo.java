package com.nla.forum.repository;

import com.nla.forum.entity.Answer;
import com.nla.forum.entity.LikeAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepo extends JpaRepository<LikeAnswer, Integer> {
    LikeAnswer findLikeById(Integer id);
    List<LikeAnswer> findAllByUserIdAndUseful(Integer userId, Integer useful);
}
