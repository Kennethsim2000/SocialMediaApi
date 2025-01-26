package com.example.Demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Demo.config.CommonResult;
import com.example.Demo.dto.AccountDto;
import com.example.Demo.dto.PostDto;
import com.example.Demo.model.Account;
import com.example.Demo.service.PostService;
import com.example.Demo.vo.AccountVo;
import com.example.Demo.vo.PostVo;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostService postService;

    //TODO: complete create post
    @PostMapping
    public CommonResult<PostVo> createPost(@RequestBody PostDto postDto) {
        PostVo res = new PostVo();
        return CommonResult.success(res, "Post successfully created");
    }

    //TODO: complete delete post
    @DeleteMapping
    public CommonResult<PostVo> deletePost(@RequestParam Long postId) {
        PostVo res = new PostVo();
        return CommonResult.success(res, "Post successfully deleted");
    }

    //TODO: retrieve posts of accounts the user is following
    @GetMapping
    @RequestMapping("following")
    public CommonResult<List<PostVo>> retrievePostsFollowing(@RequestParam Long accountId) {
        List<PostVo> res = new ArrayList<>();
        return CommonResult.success(res, "Posts successfully retrieved");
    }

    //TODO: retrieve posts created by this account
    @GetMapping
    public CommonResult<List<PostVo>> retrievePostsCreated(@RequestParam Long accountId) {
        List<PostVo> res = new ArrayList<>();
        return CommonResult.success(res, "Posts successfully retrieved");
    }



}
