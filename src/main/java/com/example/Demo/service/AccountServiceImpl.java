package com.example.Demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Demo.model.Account;
import com.example.Demo.repository.AccountRepository;

@Service
public class AccountServiceImpl implements  AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    //TODO: Complete follow method
    @Override
    public Account follow(Long followedId, Long followerId) {
        Account account = new Account();
        return account;
    }

    //TODO: Complete unfollow method
    @Override
    public Account unfollow(Long followedId, Long followerId) {
        Account account = new Account();
        return account;
    }

    //TODO: Complete get followers method
    @Override
    public List<Account> getFollowers(Long accountId) {
        List<Account> lst = new ArrayList<>();
        return lst;
    }

    //TODO: Complete get followers method
    @Override
    public List<Account> getFollowing(Long accountId) {
        List<Account> lst = new ArrayList<>();
        return lst;
    }

}
