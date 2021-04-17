package com.springboot.novoice.repository;

import com.springboot.novoice.entity.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findByUserId(Long userId);

}
