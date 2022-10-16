package com.seiferson.skullkeeper.repository;

import com.seiferson.skullkeeper.model.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface AccountRepository extends ReactiveMongoRepository<Account, String> {

    public Mono<Account> findByUsername(String username);

    public Mono<Boolean> existsByUsername(String username);
}
