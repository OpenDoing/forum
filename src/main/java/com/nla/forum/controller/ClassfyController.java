package com.nla.forum.controller;

import com.nla.forum.entity.Classify;
import com.nla.forum.repository.ClassifyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/classify")
public class ClassfyController {

    @Autowired
    private ClassifyRepo classifyRepo;

    @GetMapping("/get")
    public List<Classify> getSecond(@RequestParam Integer firstId){
        return classifyRepo.findAllByFid(firstId);
    }
}
