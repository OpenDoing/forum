package com.nla.forum.repository;

import com.nla.forum.entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RankRepo extends JpaRepository<Rank,Integer> {
    Rank findRankByUserId(Integer userId);
}
