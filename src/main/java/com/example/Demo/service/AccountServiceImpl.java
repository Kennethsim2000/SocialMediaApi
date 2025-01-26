package com.example.Demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Demo.exception.AccountExistException;
import com.example.Demo.exception.AccountNotFollowingException;
import com.example.Demo.exception.AccountNotFoundException;
import com.example.Demo.exception.SelfFollowNotAllowedException;
import com.example.Demo.model.Account;
import com.example.Demo.repository.AccountRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountServiceImpl implements  AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    @Transactional
    public Account createAccount(Account account) throws AccountExistException {
        Account existingAccount = accountRepository.findByUsername(account.getUsername());
        if(existingAccount != null) {
            throw new AccountNotFoundException("Account with username already exist");
        }
        return accountRepository.save(account);
    }

    @Override
    public Account findById(Long id) throws AccountNotFoundException {
        return accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Invalid account id provided"));
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional
    public Account follow(Long followedId, Long followerId) {
        Account follower = accountRepository.findById(followerId).orElse(null);
        Account followed = accountRepository.findById(followedId).orElse(null);
        if(follower == null || followed == null) {
            throw new AccountNotFoundException("followedId or followerId provided does not exist");
        }
        if(follower == followed) {
            throw new SelfFollowNotAllowedException("Account is not allowed to follow himself");
        }
        Set<Account> accountsFollowing = Optional.ofNullable(follower.getFollowing()).orElse(new HashSet<>());
        accountsFollowing.add(followed);
        follower.setFollowing(accountsFollowing);
        accountRepository.save(follower);
        Set<Account> followers = Optional.ofNullable(followed.getFollowers()).orElse(new HashSet<>());
        followers.add(follower);
        followed.setFollowers(followers);
        accountRepository.save(followed);
        return follower;
    }

    @Override
    @Transactional
    public Account unfollow(Long followedId, Long followerId) {
        Account follower = accountRepository.findById(followerId).orElse(null);
        Account followed = accountRepository.findById(followedId).orElse(null);
        if(follower == null || followed == null) {
            throw new AccountNotFoundException("followedId or followerId provided does not exist");
        }
        if(follower == followed) {
            throw new SelfFollowNotAllowedException("Account is not allowed to follow himself");
        }
        Set<Account> accountsFollowing = Optional.ofNullable(follower.getFollowing()).orElse(new HashSet<>());
        if(!accountsFollowing.contains(followed)) {
            throw new AccountNotFollowingException("Account is currently not following this account");
        }
        accountsFollowing.remove(followed);
        follower.setFollowing(accountsFollowing);
        accountRepository.save(follower);
        Set<Account> followers = Optional.ofNullable(followed.getFollowers()).orElse(new HashSet<>());
        followers.remove(follower);
        followed.setFollowers(followers);
        accountRepository.save(followed);
        return follower;
    }

    @Override
    public Set<Account> getFollowers(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(()-> new AccountNotFoundException("Account does not exist"));
        return account.getFollowers();
    }

    @Override
    public Set<Account> getFollowing(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(()-> new AccountNotFoundException("Account does not exist"));
        return account.getFollowing();
    }

}
