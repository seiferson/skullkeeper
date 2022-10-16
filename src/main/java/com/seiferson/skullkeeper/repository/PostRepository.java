package com.seiferson.skullkeeper.repository;

import com.seiferson.skullkeeper.model.Post;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PostRepository extends ReactiveMongoRepository<Post, String> {
}
