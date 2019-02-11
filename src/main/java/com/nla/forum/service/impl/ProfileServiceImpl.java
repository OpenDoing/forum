package com.nla.forum.service.impl;

import com.nla.forum.entity.Profile;
import com.nla.forum.repository.ProfileRepo;
import com.nla.forum.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepo profileRepo;

    @Override
    public Profile updateImg(Integer userID, String path) {
        Profile profile = new Profile();
        profile.setUserId(userID);
        profile.setAvatar(path);
        profileRepo.save(profile);
        return profile;
    }

    @Override
    public int insert(Integer userId, String atype, String avatar) {
        profileRepo.insert(userId, atype, avatar);
        return 0;
    }

    @Override
    public int update(String avatar, Integer userId) {
        profileRepo.update(avatar,userId);
        return 0;
    }
}
