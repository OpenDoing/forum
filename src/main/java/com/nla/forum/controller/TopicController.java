package com.nla.forum.controller;
import com.nla.forum.entity.Topic;
import com.nla.forum.repository.AnswerRepo;
import com.nla.forum.repository.TopicRepo;
import com.nla.forum.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicRepo topicRepo;

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

}
