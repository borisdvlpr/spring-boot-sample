package com.borisdvlpr.sample.mapper;

import com.borisdvlpr.sample.domain.CreatePostRequest;
import com.borisdvlpr.sample.domain.dto.CreatePostRequestDTO;
import com.borisdvlpr.sample.domain.dto.PostDTO;
import com.borisdvlpr.sample.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    PostDTO toDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDTO dto);
}
