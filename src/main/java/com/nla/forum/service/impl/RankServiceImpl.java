package com.nla.forum.service.impl;

import com.nla.forum.entity.Rank;
import com.nla.forum.entity.RankVO;
import com.nla.forum.entity.User;
import com.nla.forum.repository.ClassifyRepo;
import com.nla.forum.repository.RankRepo;
import com.nla.forum.repository.UserRepo;
import com.nla.forum.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RankServiceImpl implements RankService {

    @Autowired
    private RankRepo rankRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<RankVO> listRank() {
        List<Rank> list = rankRepo.findAll();
        List<RankVO> vlist = new ArrayList<>();
        for (Rank rank: list){
            RankVO rankVO = new RankVO();
            rankVO.setPoint(rank.getPoint());
            rankVO.setUserId(rank.getUserId());
            User user = userRepo.findUserById(rank.getUserId());
            rankVO.setUsername(user.getUsername());
            vlist.add(rankVO);
        }
        return vlist;
    }
}
