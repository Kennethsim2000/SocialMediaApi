package com.example.Demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Demo.config.CommonResult;
import com.example.Demo.dto.AccountDto;
import com.example.Demo.model.Account;
import com.example.Demo.service.AccountService;
import com.example.Demo.vo.AccountVo;
import com.example.Demo.vo.FollowerVo;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public CommonResult<AccountVo> createAccount(@RequestBody AccountDto accountDto) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        Account createdAcc = accountService.createAccount(account);
        AccountVo res = getAccountResponseObject(createdAcc);
        return CommonResult.success(res, "Account successfully created");
    }

    @GetMapping
    public CommonResult<AccountVo> getAccount(@RequestParam Long accountId) {
        Account acc = accountService.findById(accountId);
        AccountVo res = getAccountResponseObject(acc);
        return CommonResult.success(res, "Account successfully retrieved");
    }

    @RequestMapping("getAll")
    @GetMapping
    public CommonResult<List<AccountVo>> getAllAccount() {
        List<Account> lst = accountService.findAll();
        List<AccountVo> res = new ArrayList<>();
        for(Account acc: lst) {
            AccountVo resObj = getAccountResponseObject(acc);
            res.add(resObj);
        }
        return CommonResult.success(res, "All Accounts successfully retrieved");
    }

    @RequestMapping("follow")
    @PostMapping
    public CommonResult<AccountVo> follow(@RequestParam Long followedId, @RequestParam Long followerId) {
        Account acc = accountService.follow(followedId, followerId);
        AccountVo res = getAccountResponseObject(acc);
        return CommonResult.success(res, "Follow request completed");
    }

    @RequestMapping("unfollow")
    @PostMapping
    public CommonResult<AccountVo> unfollow(@RequestParam Long followedId, @RequestParam Long followerId) {
        Account acc = accountService.unfollow(followedId, followerId);
        AccountVo res = getAccountResponseObject(acc);
        return CommonResult.success(res, "Unfollow request completed");
    }

    @RequestMapping("follower")
    @GetMapping
    public CommonResult<List<FollowerVo>> getFollowers(@RequestParam Long accountId) {
        Set<Account> followers = accountService.getFollowers(accountId);
        List<FollowerVo> lst = getFollowerResponseObject(followers);
        return CommonResult.success(lst, "Followers successfully retrieved");
    }

    @RequestMapping("following")
    @GetMapping
    public CommonResult<List<FollowerVo>> getFollowing(@RequestParam Long accountId) {
        Set<Account> following = accountService.getFollowing(accountId);
        List<FollowerVo> lst = getFollowerResponseObject(following);
        return CommonResult.success(lst, "Accounts following successfully retrieved");
    }

    public AccountVo getAccountResponseObject(Account acc) {
        AccountVo res = new AccountVo();
        res.setUsername(acc.getUsername());
        res.setEmail(acc.getEmail());
        Set<String> followers = new HashSet<>();
        if(acc.getFollowers() != null) {
            Iterator<Account> followersIterator = acc.getFollowers().iterator();
            while(followersIterator.hasNext()) {
                followers.add(followersIterator.next().getUsername());
            }
        }
        res.setFollowers(followers);
        Set<String> following = new HashSet<>();
        if(acc.getFollowing() != null) {
            Iterator<Account> followingIterator = acc.getFollowing().iterator();
            while(followingIterator.hasNext()) {
                following.add(followingIterator.next().getUsername());
            }
        }
        res.setFollowing(following);
        return res;
    }

    public List<FollowerVo> getFollowerResponseObject(Set<Account> followers) {
        List<FollowerVo> lst = new ArrayList<>();
        Iterator<Account> followersIterator = followers.iterator();
        while(followersIterator.hasNext()) {
            Account acc = followersIterator.next();
            FollowerVo vo = new FollowerVo();
            vo.setId(acc.getId());
            vo.setEmail(acc.getEmail());
            vo.setUsername(acc.getUsername());
            lst.add(vo);
        }
        return lst;
    }

}
