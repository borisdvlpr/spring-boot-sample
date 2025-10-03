package com.borisdvlpr.sample.service;


import com.borisdvlpr.sample.domain.entities.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
}
