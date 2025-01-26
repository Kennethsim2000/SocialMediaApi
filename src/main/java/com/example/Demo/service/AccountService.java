package com.example.Demo.service;

import java.util.List;
import java.util.Set;

import com.example.Demo.model.Account;

public interface AccountService {
    public Account createAccount(Account account);
    public Account findById(Long id);
    public List<Account> findAll();
    public Account follow(Long followedId, Long followerId);
    public Account unfollow(Long followedId, Long followerId);
    public Set<Account> getFollowers(Long accountId);
    public Set<Account> getFollowing(Long accountId);
}
