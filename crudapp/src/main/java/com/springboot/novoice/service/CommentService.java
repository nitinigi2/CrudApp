package com.springboot.novoice.service;

import com.springboot.novoice.entity.Comment;
import com.springboot.novoice.entity.Post;
import com.springboot.novoice.entity.User;
import com.springboot.novoice.exception.ResourceNotFoundException;
import com.springboot.novoice.repository.CommentRepository;
import com.springboot.novoice.repository.PostRepository;
import com.springboot.novoice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Comment saveComment(Long userId, Long postId, Comment comment) {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Post> optionalPost = postRepository.findById(postId);

        if (!optionalUser.isPresent() || !optionalPost.isPresent()) {
            throw new ResourceNotFoundException();
        }

        comment.setUser(optionalUser.get());
        comment.setPost(optionalPost.get());

        commentRepository.save(comment);

        return comment;
    }

    /**
     * finding comments by commentId
     *
     * @param commentId
     */
    public Comment findComment(Long commentId) {
        Optional optionalComment = commentRepository.findById(commentId);
        if (optionalComment.isPresent()) {
            return (Comment) optionalComment.get();
        }
        return null;
    }

    /**
     * finding all comments on particular post
     *
     * @param postId
     */
    public List<Comment> findAllComments(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public void deleteComment(Long userId, Long postId, Long commentId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Post> optionalPost = postRepository.findById(postId);
        Optional<Comment> optionalComment = commentRepository.findById(commentId);

        if (!optionalUser.isPresent() || optionalPost.isPresent() || !optionalComment.isPresent()) {
            throw new ResourceNotFoundException();
        }

        Comment comment = optionalComment.get();
        comment.setUser(optionalUser.get());
        comment.setPost(optionalPost.get());

        commentRepository.delete(comment);
    }
}
