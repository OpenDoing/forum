package com.nla.forum.controller;
import com.nla.forum.entity.Recommend;
import com.nla.forum.repository.RecommendRepo;
import com.nla.forum.util.JacksonUtil;
import com.nla.forum.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/recommend")
public class RecommendController {

    @Autowired
    private RecommendRepo recommendRepo;

    @PostMapping("/chakan")
    public Object setChakanFocus(@RequestBody String body) {
        String userId = JacksonUtil.parseString(body, "userId");
        String topicId = JacksonUtil.parseString(body, "topicId");
        Integer focus = Integer.parseInt(JacksonUtil.parseString(body, "focus"));

        Recommend recommend = new Recommend();
        recommend.setUserId(Integer.parseInt(userId));
        recommend.setTopicId(Integer.parseInt(topicId));
        focus += 1;
        recommend.setFocus(focus);
        recommendRepo.save(recommend);
        return ResponseUtil.ok(recommend);
    }

    @PostMapping("/zan")
    public Object setZanFocus(@RequestBody String body) {
        String userId = JacksonUtil.parseString(body, "userId");
        String topicId = JacksonUtil.parseString(body, "topicId");
        Integer focus = Integer.parseInt(JacksonUtil.parseString(body, "focus"));

        Recommend recommend = new Recommend();
        recommend.setUserId(Integer.parseInt(userId));
        recommend.setTopicId(Integer.parseInt(topicId));
        focus += 2;
        recommend.setFocus(focus);
        recommendRepo.save(recommend);
        return ResponseUtil.ok(recommend);
    }

    @PostMapping("/reply")
    public Object setReplyFocus(@RequestBody String body) {
        String userId = JacksonUtil.parseString(body, "userId");
        String topicId = JacksonUtil.parseString(body, "topicId");
        Integer focus = recommendRepo.findRecommendByUserIdAndTopicId(Integer.parseInt(userId), Integer.parseInt(topicId)).getFocus();

        Recommend recommend = new Recommend();
        recommend.setUserId(Integer.parseInt(userId));
        recommend.setTopicId(Integer.parseInt(topicId));
        focus += 3;
        recommend.setFocus(focus);
        recommendRepo.save(recommend);
        return ResponseUtil.ok(recommend);
    }


}
