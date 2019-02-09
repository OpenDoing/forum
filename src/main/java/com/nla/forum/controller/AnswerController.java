package com.nla.forum.controller;

import com.nla.forum.entity.Answer;
import com.nla.forum.entity.AnswerVO;
import com.nla.forum.entity.Rank;
import com.nla.forum.entity.Topic;
import com.nla.forum.repository.AnswerRepo;
import com.nla.forum.repository.RankRepo;
import com.nla.forum.repository.TopicRepo;
import com.nla.forum.service.AnswerService;
import com.nla.forum.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerRepo answerRepo;

    @Autowired
    private RankRepo rankRepo;

    @Autowired
    private AnswerService answerService;

    @PostMapping("/add")
    public Object addTopic(@RequestBody Answer answer) {
        //1 添加回复
        LocalDateTime now = LocalDateTime.now();
        answer.setCreatetime(now);
        answer.setScore(0);
        answerRepo.save(answer);
        //2 更新rank point
        int uid = answer.getUserId();
        int point = rankRepo.findRankByUserId(uid).getPoint();
        point += 2;
        Rank rank = new Rank();
        rank.setPoint(point);
        rank.setUserId(uid);
        rankRepo.save(rank);
        return ResponseUtil.ok(answer);
    }

    @DeleteMapping("/delete")
    public Object deleteTopic(@RequestParam String answerId) {
        answerRepo.deleteById(Integer.parseInt(answerId));
        return ResponseUtil.ok();
    }

//    @PutMapping("/zan")
//    public Object zan(@RequestParam String answerId) {
//        Answer add = answerRepo.findAnswerById(Integer.parseInt(answerId));
//        int newUseful = add.getUseful();
//        newUseful = newUseful + 1;
//        add.setUseful(newUseful);
//        answerRepo.save(add);
//        return ResponseUtil.ok(add);
//    }

    @PutMapping("/score")
    public Object score(@RequestParam String answerId,
                        @RequestParam String score) {
        Answer add = answerRepo.findAnswerById(Integer.parseInt(answerId));
        add.setScore(Integer.parseInt(score));
        answerRepo.save(add);
        return ResponseUtil.ok(add);
    }

    @GetMapping("/get")
    public List<AnswerVO> getAnswer(@RequestParam Integer topicId, @RequestParam Integer userId, @RequestParam String username) {
        return answerService.listAnswers(topicId,userId,username);

    }

}
