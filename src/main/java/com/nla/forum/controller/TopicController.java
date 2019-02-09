package com.nla.forum.controller;
import com.nla.forum.entity.Topic;
import com.nla.forum.entity.TopicVO;
import com.nla.forum.repository.AnswerRepo;
import com.nla.forum.repository.TopicRepo;
import com.nla.forum.service.TopicService;
import com.nla.forum.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicRepo topicRepo;

    @Autowired
    private TopicService topicService;

    @PostMapping("/add")
    public Object addTopic(@RequestBody Topic topic) {
        LocalDateTime now = LocalDateTime.now();
        topic.setCreatedDate(now);
        System.out.println(topic.toString());
        topicRepo.save(topic);
        return ResponseUtil.ok(topic);
    }

    @DeleteMapping("/delete")
    public Object deleteTopic(@RequestParam String topicId) {
        topicRepo.deleteById(Integer.parseInt(topicId));
        return ResponseUtil.ok();
    }

    @GetMapping("/all")
    public List<TopicVO> getAll(@RequestParam Integer userId) {
        return topicService.getAllTopic(userId);
    }

    @GetMapping("/category")
    public List<TopicVO> getAllByCategory(@RequestParam Integer userId, @RequestParam String category) {
        return topicService.getAllTopicByCategory(userId, category);
    }

    @GetMapping("/get")
    public Topic getOne(@RequestParam Integer topicId) {
//        Topic topic =
        return topicRepo.findTopicById(topicId);
    }

}
