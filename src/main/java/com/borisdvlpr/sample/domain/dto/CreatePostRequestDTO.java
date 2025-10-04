package com.borisdvlpr.sample.domain.dto;

import com.borisdvlpr.sample.domain.PostStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePostRequestDTO {
    @NotBlank(message = "Title is required.")
    @Size(min = 3, max = 100, message = "Title must be between {min} and {max} characters.")
    private String title;

    @NotBlank(message = "Content is required.")
    @Size(min = 50, max = 50000, message = "Contents must be between {min} and {max} characters.")
    private String content;

    @NotBlank(message = "Category ID is required.")
    private UUID categoryId;

    @Builder.Default
    @Size(max = 10, message = "Maximum {max} tags allowed.")
    private Set<UUID> tagIds = new HashSet<>();

    @NotNull(message = "Status is required.")
    private PostStatus postStatus;
}
