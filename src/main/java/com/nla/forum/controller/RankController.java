package com.nla.forum.controller;
import com.nla.forum.repository.RankRepo;
import com.nla.forum.service.RankService;
import com.nla.forum.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/rank")
public class RankController {

    @Autowired
    private RankRepo rankRepo;

    @Autowired
    private RankService rankService;

    @GetMapping("/get")
    public Object get(@RequestParam Integer userId){
        return ResponseUtil.ok(rankRepo.findRankByUserId(userId));
    }

    @GetMapping("/all")
    public Object getAll(){
        return ResponseUtil.ok(rankService.listRank());
    }
}
