package com.nla.forum.repository;

import com.nla.forum.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendRepo extends JpaRepository<Recommend,Integer> {
}
