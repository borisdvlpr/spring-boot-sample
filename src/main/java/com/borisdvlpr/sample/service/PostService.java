package com.borisdvlpr.sample.service;


import com.borisdvlpr.sample.domain.entities.Post;
import com.borisdvlpr.sample.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllPosts(UUID categoryId, UUID tagId);

    List<Post> getDraftPosts(User user);
}
