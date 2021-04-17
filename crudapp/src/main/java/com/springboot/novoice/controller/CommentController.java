package com.springboot.novoice.controller;

import com.springboot.novoice.entity.Comment;
import com.springboot.novoice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/users/{userId}/posts/{postId}/comments")
    public ResponseEntity<?> saveComment(@PathVariable("userId") Long userId,
                                         @PathVariable("postId") Long postId,
                                         @RequestBody Comment comment) {
        Comment savedComment = commentService.saveComment(userId, postId, comment);
        return ResponseEntity.status(HttpStatus.OK).body(savedComment);
    }

    @DeleteMapping("/users/{userId}/posts/{postId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable("userId") Long userId,
                                           @PathVariable("postId") Long postId,
                                           @PathVariable("commentId") Long commentId) {
        commentService.deleteComment(userId, postId, commentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/posts/{postId}/comments")
    public List<Comment> retrieveAllComment(@PathVariable("postId") Long postId) {
        return commentService.findAllComments(postId);
    }

    @GetMapping("/comments/{commentId}")
    public ResponseEntity<?> retrieveComment(@PathVariable("commentId") Long commentId) {
        Comment comment = commentService.findComment(commentId);
        return ResponseEntity.status(HttpStatus.OK).body(comment);
    }

}
