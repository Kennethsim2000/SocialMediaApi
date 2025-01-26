package com.example.Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Demo.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
