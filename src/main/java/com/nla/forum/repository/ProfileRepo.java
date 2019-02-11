package com.nla.forum.repository;


import com.nla.forum.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ProfileRepo extends JpaRepository<Profile,Integer> {

    @Modifying
    @Query(value = "INSERT INTO profile(user_id,atype,avatar) VALUES (?1, ?2, ?3)", nativeQuery = true)
    int insert(Integer userId, String atype, String avatar);

    @Modifying
    @Transactional
    @Query(value = "update profile set avatar= ?1 where user_id= ?2", nativeQuery = true)
    int update(String avatar,Integer userId);

    Profile findProfileByUserId(Integer userId);
}
