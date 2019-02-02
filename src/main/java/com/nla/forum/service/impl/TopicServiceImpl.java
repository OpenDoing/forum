package com.nla.forum.service.impl;

import com.nla.forum.entity.Topic;
import com.nla.forum.entity.TopicVO;
import com.nla.forum.entity.User;
import com.nla.forum.repository.RecommendRepo;
import com.nla.forum.repository.TopicRepo;
import com.nla.forum.repository.UserRepo;
import com.nla.forum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepo topicRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RecommendRepo recommendRepo;

    @Override
    public List<TopicVO> getAllTopic(Integer userId) {
        List<Topic> list = topicRepo.findAll();
        List<TopicVO> vlist = new ArrayList<>();
        for (Topic topic:list){
            TopicVO topicVO = new TopicVO();
            topicVO.setCategory(topic.getCategory());
            topicVO.setCreatedDate(topic.getCreatedDate());
            topicVO.setTitle(topic.getTitle());
            topicVO.setUserId(topic.getUserId());
            User user = userRepo.findUserById(topic.getUserId());
            int focus = 0;
            try{
                focus = recommendRepo.findRecommendByUserIdAndTopicId(userId, topic.getId()).getFocus();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
            topicVO.setFocus(focus);
            topicVO.setUsername(user.getUsername());
            vlist.add(topicVO);
        }
        return vlist;
    }

    @Override
    public List<TopicVO> getAllTopicByCategory(Integer userId, String category) {
        List<Topic> list = topicRepo.findAllByCategory(category);
        List<TopicVO> vlist = new ArrayList<>();
        for (Topic topic:list){
            TopicVO topicVO = new TopicVO();
            topicVO.setCategory(topic.getCategory());
            topicVO.setCreatedDate(topic.getCreatedDate());
            topicVO.setTitle(topic.getTitle());
            topicVO.setUserId(topic.getUserId());
            User user = userRepo.findUserById(topic.getUserId());
            int focus = 0;
            try{
                focus = recommendRepo.findRecommendByUserIdAndTopicId(userId, topic.getId()).getFocus();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
            topicVO.setFocus(focus);
            topicVO.setUsername(user.getUsername());
            vlist.add(topicVO);
        }
        return vlist;
    }
}
