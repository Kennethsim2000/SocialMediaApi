package com.example.Demo.service;

import java.util.List;

import com.example.Demo.model.Post;

public interface PostService {
    public Post savePost(Post post);
    public Post deletePost(Long postId);
    public List<Post> retrievePostsFollowing(Long accountId);
    public List<Post> retrievePostsCreated(Long accountId);
}
