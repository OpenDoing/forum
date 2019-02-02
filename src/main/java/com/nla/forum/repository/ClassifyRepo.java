package com.nla.forum.repository;

import com.nla.forum.entity.Classify;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassifyRepo extends JpaRepository<Classify, Integer> {

    List<Classify> findAllByFid(Integer firstId);


}
