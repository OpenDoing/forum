package com.nla.forum.service;

import com.nla.forum.entity.Profile;

public interface ProfileService {
    Profile updateImg(Integer userID, String path);
    int insert(Integer userId, String atype, String avatar);
    int update(String avatar,Integer userId);
}
