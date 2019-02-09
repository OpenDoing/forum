package com.nla.forum.controller;

import com.nla.forum.entity.Answer;
import com.nla.forum.entity.LikeAnswer;
import com.nla.forum.entity.Rank;
import com.nla.forum.repository.AnswerRepo;
import com.nla.forum.repository.LikeRepo;
import com.nla.forum.repository.RankRepo;
import com.nla.forum.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeRepo likeRepo;

    @Autowired
    private RankRepo rankRepo;

    @Autowired
    private AnswerRepo answerRepo;

    /**
     *
     * @param likeAnswer:{
                "id":3,
                "userId":2
                }
     * @return ok
     */
    @PostMapping("/reverse")
    public Object add(@RequestBody LikeAnswer likeAnswer){
        LikeAnswer result = likeRepo.findLikeAnswerByIdAndUserId(likeAnswer.getId(), likeAnswer.getUserId());
        if (result == null) {
            likeAnswer.setUseful(1);
            likeRepo.save(likeAnswer);

            //更新rank point  赞别人+1
            int uid = likeAnswer.getUserId();
            Rank rank = new Rank();
            rank.setUserId(uid);
            int point = rankRepo.findRankByUserId(uid).getPoint();
            point += 1;
            rank.setPoint(point);
            rankRepo.save(rank);

            //更新rank point  被赞+3
            int pUid = answerRepo.findAnswerById(likeAnswer.getId()).getUserId();
            int passive = rankRepo.findRankByUserId(pUid).getPoint();
            passive += 3;
            Rank prank = new Rank();
            prank.setUserId(pUid);
            prank.setPoint(passive);
            rankRepo.save(prank);
        }else {
            if (result.getUseful() == 1) {
                likeAnswer.setUseful(0);
                //更新rank point  取消赞别人  -1
                int uid = likeAnswer.getUserId();
                Rank rank = new Rank();
                rank.setUserId(uid);
                int point = rankRepo.findRankByUserId(uid).getPoint();
                point -= 1;
                rank.setPoint(point);
                rankRepo.save(rank);

                //更新rank point  取消被赞-3
                int pUid = answerRepo.findAnswerById(likeAnswer.getId()).getUserId();
                int passive = rankRepo.findRankByUserId(pUid).getPoint();
                passive -= 3;
                Rank prank = new Rank();
                prank.setUserId(pUid);
                prank.setPoint(passive);
                rankRepo.save(prank);

            } else {
                likeAnswer.setUseful(1);
                //更新rank point  赞别人+1
                int uid = likeAnswer.getUserId();
                Rank rank = new Rank();
                rank.setUserId(uid);
                int point = rankRepo.findRankByUserId(uid).getPoint();
                point += 1;
                rank.setPoint(point);
                rankRepo.save(rank);

                //更新rank point  被赞+3
                int pUid = answerRepo.findAnswerById(likeAnswer.getId()).getUserId();
                int passive = rankRepo.findRankByUserId(pUid).getPoint();
                passive += 3;
                Rank prank = new Rank();
                prank.setUserId(pUid);
                prank.setPoint(passive);
                rankRepo.save(prank);
            }
            likeRepo.save(likeAnswer);
        }
        return ResponseUtil.ok(likeAnswer);
    }

    /**
     * 获取某个回答有多少个赞
     * @param id answerId
     * @return
     */
    @GetMapping("/count")
    public Object getLike(@RequestParam Integer id) {
        List<LikeAnswer> list = likeRepo.findAllByIdAndUseful(id, 1);
        return ResponseUtil.ok(list.size());
    }
}
