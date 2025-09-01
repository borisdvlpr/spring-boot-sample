package com.borisdvlpr.sample.mapper;

import com.borisdvlpr.sample.domain.PostStatus;
import com.borisdvlpr.sample.domain.dto.CategoryDTO;
import com.borisdvlpr.sample.domain.dto.CreateCategoryRequest;
import com.borisdvlpr.sample.domain.entities.Category;
import com.borisdvlpr.sample.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDTO toDTO(Category category);

    Category toEntity(CreateCategoryRequest createCategoryRequest);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if(posts == null) {
            return 0;
        }

        return posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}
