package com.nla.forum.controller;
import com.nla.forum.repository.ProfileRepo;
import com.nla.forum.service.ProfileService;
import com.nla.forum.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileRepo profileRepo;

    @Value("${imgpath}")
    private String filePath;

    @PostMapping(value = "/fileUpload")
    public Object fileUpload(@RequestParam(value = "file") MultipartFile file, Integer userId) {
        if (file.isEmpty()) {
            return ResponseUtil.fail(404, "文件为空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名

        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseUtil.fail(-1,"上传失败");
        }
        System.out.println(dest.getName());
        System.out.println(userId);
        profileService.update(dest.getName(),userId);

        return ResponseUtil.ok("上传成功",dest.getName());
    }

    @GetMapping("/get")
    public Object getProfile(@RequestParam Integer userId) {
        return  ResponseUtil.ok(profileRepo.findProfileByUserId(userId));
    }
}
