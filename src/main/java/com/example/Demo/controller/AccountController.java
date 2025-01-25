package com.example.Demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Demo.config.CommonResult;
import com.example.Demo.dto.AccountDto;
import com.example.Demo.dto.UserDto;
import com.example.Demo.model.User;
import com.example.Demo.service.AccountService;
import com.example.Demo.vo.AccountVo;
import com.example.Demo.vo.UserVo;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    //TODO: Complete adding social media account
    @PostMapping
    public CommonResult<AccountVo> createAccount(@RequestBody AccountDto accountDto) {
        AccountVo res = new AccountVo();
        return CommonResult.success(res, "Account successfully created");
    }

    //TODO: Complete retrieval of account by id
    @GetMapping
    public CommonResult<AccountVo> getAccount(@RequestParam Long id) {
        AccountVo res = new AccountVo();
        return CommonResult.success(res, "Account successfully retrieved");
    }

    //TODO: complete retrieval of all accounts
    @RequestMapping("getAll")
    @GetMapping
    public CommonResult<List<AccountVo>> getAllAccount() {
        List<AccountVo> lst = new ArrayList<>();
        return CommonResult.success(lst, "All Accounts successfully retrieved");
    }

    //TODO: Complete follow endpoint
    @RequestMapping("follow")
    @PostMapping
    public CommonResult<AccountVo> follow(@RequestParam Long followedId, @RequestParam Long followerId) {
        AccountVo res = new AccountVo();
        return CommonResult.success(res, "Follow request completed");
    }

    @RequestMapping("unfollow")
    @PostMapping
    public CommonResult<AccountVo> unfollow(@RequestParam Long followedId, @RequestParam Long followerId) {
        AccountVo res = new AccountVo();
        return CommonResult.success(res, "Follow request completed");
    }

    //TODO: Get followers
    @RequestMapping("follower")
    @GetMapping
    public CommonResult<List<AccountVo>> getFollowers(@RequestParam Long accountId) {
        List<AccountVo> lst = new ArrayList<>();
        return CommonResult.success(lst, "Followers successfully retrieved");
    }

    //TODO: Get following
    @RequestMapping("following")
    @GetMapping
    public CommonResult<List<AccountVo>> getFollowing(@RequestParam Long accountId) {
        List<AccountVo> lst = new ArrayList<>();
        return CommonResult.success(lst, "Accounts following successfully retrieved");
    }


}
