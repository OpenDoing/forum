package com.nla.forum.service;

import com.nla.forum.entity.AnswerVO;

import java.util.List;

public interface AnswerService {

    List<AnswerVO> listAnswers(Integer topicId, Integer userId, String username);
}
