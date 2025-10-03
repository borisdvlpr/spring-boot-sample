package com.borisdvlpr.sample.repository;

import com.borisdvlpr.sample.domain.PostStatus;
import com.borisdvlpr.sample.domain.entities.Category;
import com.borisdvlpr.sample.domain.entities.Post;
import com.borisdvlpr.sample.domain.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findAllByStatusAndCategoryAndTagsContaining(PostStatus status, Category category, Tag tag);

    List<Post> findAllByStatusAndCategory(PostStatus status, Category category);

    List<Post> findAllByStatusAndTagsContaining(PostStatus status, Tag tag);

    List<Post> findAllByStatus(PostStatus status);
}
