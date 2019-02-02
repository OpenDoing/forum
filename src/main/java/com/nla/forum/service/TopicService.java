package com.nla.forum.service;


import com.nla.forum.entity.TopicVO;

import java.util.List;

public interface TopicService {

    List<TopicVO> getAllTopic(Integer userId);
    List<TopicVO> getAllTopicByCategory(Integer userId, String category);
}
