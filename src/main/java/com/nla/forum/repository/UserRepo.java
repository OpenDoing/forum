package com.nla.forum.repository;

import com.nla.forum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface UserRepo extends JpaRepository<User,Integer> {
    User findUserByUsername(String username);
    User findUserById(Integer id);
    List<User> findUsersByRole(Integer role);

    @Modifying
    @Transactional
    @Query(value = "update user set status= ?1 where id= ?2", nativeQuery = true)
    int updateStatus(Integer status, Integer userId);
}
