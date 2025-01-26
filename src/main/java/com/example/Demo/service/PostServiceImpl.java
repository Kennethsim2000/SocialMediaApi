package com.example.Demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Demo.model.Post;
import com.example.Demo.repository.AccountRepository;
import com.example.Demo.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    AccountRepository accountRepository;

    //TODO: Complete saving of post
    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    //TODO: Complete deleting of post
    @Override
    public Post deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElse(null);
        postRepository.delete(post);
        return post;
    }

    //TODO: Complete retrieving post based on following
    @Override
    public List<Post> retrievePostsFollowing(Long accountId) {
        List<Post> res = new ArrayList<>();
        return res;
    }

    //TODO: Complete retrieving post created by this account
    @Override
    public List<Post> retrievePostsCreated(Long accountId) {
        List<Post> res = new ArrayList<>();
        return res;
    }
}
