package com.borisdvlpr.sample.service;


import com.borisdvlpr.sample.domain.CreatePostRequest;
import com.borisdvlpr.sample.domain.UpdatePostRequest;
import com.borisdvlpr.sample.domain.entities.Post;
import com.borisdvlpr.sample.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllPosts(UUID categoryId, UUID tagId);

    Post getPost(UUID id);

    List<Post> getDraftPosts(User user);

    Post createPost(User user, CreatePostRequest createPostRequest);

    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);

    void deletePost(UUID id);
}
