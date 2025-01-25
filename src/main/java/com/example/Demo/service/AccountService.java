package com.example.Demo.service;

import java.util.List;

import com.example.Demo.model.Account;

public interface AccountService {
    public Account saveAccount(Account account);
    public Account findById(Long id);
    public List<Account> findAll();
    public Account follow(Long followedId, Long followerId);
    public Account unfollow(Long followedId, Long followerId);
    public List<Account> getFollowers(Long accountId);
    public List<Account> getFollowing(Long accountId);
}
