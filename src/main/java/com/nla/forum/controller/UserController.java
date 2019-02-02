package com.nla.forum.controller;
import com.nla.forum.entity.Rank;
import com.nla.forum.entity.User;
import com.nla.forum.repository.RankRepo;
import com.nla.forum.repository.UserRepo;
import com.nla.forum.util.CharUtil;
import com.nla.forum.util.JacksonUtil;
import com.nla.forum.util.ResponseUtil;
import com.nla.forum.util.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RankRepo rankRepo;

    @PostMapping("/login")
    public Object login(@RequestBody String body){
        String username = JacksonUtil.parseString(body, "username");
        String password = JacksonUtil.parseString(body, "password");

        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return ResponseUtil.badArgument();
        }
        User user = userRepo.findUserByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!encoder.matches(password, user.getPassword())){
            return ResponseUtil.fail(403, "账号密码不对");
        }
        User newUser = updateToken(user);
        userRepo.save(newUser);
        newUser.setPassword(null);
        return ResponseUtil.ok(newUser);
    }

    @PostMapping("/register")
    public Object reg(@RequestParam String username,
                      @RequestParam String password,
                      @RequestParam String role){
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return ResponseUtil.badArgument();
        }

        User user = userRepo.findUserByUsername(username);
        if(user != null){
            return ResponseUtil.regerr();
        }
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setRole(Integer.parseInt(role));
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        newUser.setPassword(encoder.encode(password));
        User reg = updateToken(newUser);
        newUser.setToken(reg.getToken());
        newUser.setUpdatetime(reg.getUpdatetime());
        newUser.setExpiretime(reg.getExpiretime());
        //添加Rank表信息
        User urank = userRepo.save(newUser);
        Rank rank = new Rank();
        rank.setUserId(urank.getId());
        rank.setPoint(0);
        rankRepo.save(rank);
        return ResponseUtil.ok();
    }

    //更新token
    private User updateToken(User user) {
        LocalDateTime now = LocalDateTime.now();
        //token过期  刷新token
        if(user.getExpiretime() == null || user.getExpiretime().isBefore(now) || user.getToken() == null){
            LocalDateTime expire = now.plusMinutes(60);
            user.setUpdatetime(now);
            user.setExpiretime(expire);
            String tokenNew = CharUtil.getRandomString(32);
            user.setToken(tokenNew);
        }
        return user;
    }
}
