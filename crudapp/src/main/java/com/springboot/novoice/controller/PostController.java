package com.springboot.novoice.controller;

import com.springboot.novoice.entity.Post;
import com.springboot.novoice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/users/{userId}/posts")
    public List<Post> retrieveAllPost(@PathVariable("userId") Long userId) {
        return postService.findAllPost(userId);
    }

    @GetMapping("/posts/{postId}")
    public Post retrievePost(@PathVariable("postId") Long postId) {
        return postService.findByPostId(postId);
    }

    @PostMapping("/users/{userId}/posts")
    public Post savePost(@PathVariable("userId") Long userId, @RequestBody Post post){
        return postService.save(userId, post);
    }
}
