package com.example.webflux_test.repository;

import com.example.webflux_test.model.Post;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author HelloWood
 * @date 2019-01-08 14:22
 */
public interface PostRepository extends ReactiveCrudRepository<Post, Long> {

}
