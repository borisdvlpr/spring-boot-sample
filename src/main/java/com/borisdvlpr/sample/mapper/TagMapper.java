package com.borisdvlpr.sample.mapper;

import com.borisdvlpr.sample.domain.PostStatus;
import com.borisdvlpr.sample.domain.dto.TagResponse;
import com.borisdvlpr.sample.domain.entities.Post;
import com.borisdvlpr.sample.domain.entities.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TagMapper {
    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCounts")
    TagResponse toTagResponse(Tag tag);

    @Named("calculatePostCounts")
    default Integer calculatePostCounts(Set<Post> posts) {
        if (posts == null) {
            return 0;
        }

        return (int) posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}
