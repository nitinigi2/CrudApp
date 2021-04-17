package com.springboot.novoice.service;

import com.springboot.novoice.entity.Post;
import com.springboot.novoice.entity.User;
import com.springboot.novoice.exception.ResourceNotFoundException;
import com.springboot.novoice.repository.PostRepository;
import com.springboot.novoice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Post save(Long userId, Post post){
        Optional<User> optional = userRepository.findById(userId);
        if(!optional.isPresent()) {
            throw new ResourceNotFoundException();
        }
        post.setUser(optional.get());
        return postRepository.save(post);
    }

    public Post delete(Long id){
        Optional<Post> optional = postRepository.findById(id);
        if(optional.isPresent()){
            postRepository.delete(optional.get());
            return optional.get();
        }
        return null;
    }

    public List<Post> findAllPost(Long userId){
        Optional<User> optional = userRepository.findById(userId);
        if(optional.isPresent()) {
            return postRepository.findByUserId(userId);
        }
        throw new ResourceNotFoundException();
    }

    public Post findByPostId(Long postId){
        Optional<Post> optionalPost = postRepository.findById(postId);
        if(optionalPost.isPresent()){
            return optionalPost.get();
        }
        return null;
    }

}
