package com.borisdvlpr.sample.controller;

import com.borisdvlpr.sample.domain.CreatePostRequest;
import com.borisdvlpr.sample.domain.UpdatePostRequest;
import com.borisdvlpr.sample.domain.dto.CreatePostRequestDTO;
import com.borisdvlpr.sample.domain.dto.PostDTO;
import com.borisdvlpr.sample.domain.dto.UpdatePostRequestDTO;
import com.borisdvlpr.sample.domain.entities.Post;
import com.borisdvlpr.sample.domain.entities.User;
import com.borisdvlpr.sample.mapper.PostMapper;
import com.borisdvlpr.sample.service.PostService;
import com.borisdvlpr.sample.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostMapper postMapper;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts(
            @RequestParam(required = false) UUID categoryId,
            @RequestParam(required = false) UUID tagId
    ) {
        List<Post> posts = postService.getAllPosts(categoryId, tagId);
        List<PostDTO> postDtos = posts.stream().map(postMapper::toDto).toList();

        return ResponseEntity.ok(postDtos);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PostDTO> getPost(
            @PathVariable UUID id
    ) {
        Post post = postService.getPost(id);
        PostDTO postDto = postMapper.toDto(post);

        return ResponseEntity.ok(postDto);
    }

    @GetMapping(path = "/drafts")
    public ResponseEntity<List<PostDTO>> getDrafts(@RequestAttribute UUID userId) {
        User loggedInUser = userService.getUserById(userId);
        List<Post> draftPosts = postService.getDraftPosts(loggedInUser);
        List<PostDTO> postDtos = draftPosts.stream().map(postMapper::toDto).toList();

        return ResponseEntity.ok(postDtos);
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(
            @Valid @RequestBody CreatePostRequestDTO createPostRequestDTO,
            @RequestAttribute UUID userId
    ) {
        User loggedInUser = userService.getUserById(userId);
        CreatePostRequest createPostRequest = postMapper.toCreatePostRequest(createPostRequestDTO);
        Post createdPost = postService.createPost(loggedInUser, createPostRequest);
        PostDTO createdPostDTO = postMapper.toDto(createdPost);

        return new ResponseEntity<>(createdPostDTO, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PostDTO> updatePost(
            @PathVariable UUID id,
            @Valid @RequestBody UpdatePostRequestDTO updatePostRequestDTO
    ) {
        UpdatePostRequest updatePostRequest = postMapper.toUpdatePostRequest(updatePostRequestDTO);
        Post updatedPost = postService.updatePost(id, updatePostRequest);
        PostDTO updatedPostDto = postMapper.toDto(updatedPost);

        return ResponseEntity.ok(updatedPostDto);
    }
}
