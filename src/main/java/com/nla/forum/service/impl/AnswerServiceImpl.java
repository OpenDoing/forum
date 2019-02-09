package com.nla.forum.service.impl;

import com.nla.forum.entity.Answer;
import com.nla.forum.entity.AnswerVO;
import com.nla.forum.entity.LikeAnswer;
import com.nla.forum.repository.AnswerRepo;
import com.nla.forum.repository.LikeRepo;
import com.nla.forum.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepo answerRepo;

    @Autowired
    private LikeRepo likeRepo;

    @Override
    public List<AnswerVO> listAnswers(Integer topicId, Integer userId, String username) {
        List<Answer> list = answerRepo.findAnswersByTopicId(topicId);
        List<AnswerVO> vlist = new ArrayList<>();
        for (Answer answer:list) {
            AnswerVO answerVO = new AnswerVO();
            answerVO.setContent(answer.getContent());
            answerVO.setCreatetime(answer.getCreatetime());
            answerVO.setId(answer.getId());
            answerVO.setTopicId(topicId);
            answerVO.setScore(answer.getScore());
            answerVO.setUserId(userId);
            answerVO.setUsername(answer.getUsername());
            Integer useful = likeRepo.findAllByIdAndUseful(answer.getId(),1).size();
            answerVO.setUseful(useful);
            Boolean judge = false;
            Integer result = 0;
            try{
                result  = likeRepo.findLikeAnswerByIdAndUserId(answer.getId(), userId).getUseful();
            }catch (Exception e){

            }
            if (result == 1) {
                judge = true;
            }
            answerVO.setJudge(judge);
            vlist.add(answerVO);
        }
        return vlist;
    }
}
