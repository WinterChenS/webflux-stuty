package com.example.flux.repository;

import com.example.flux.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import reactor.core.publisher.Flux;

/**
 * @author CENTURY
 * @version 1.0
 * @date 2021/9/22 14:19
 **/
@EnableMongoRepositories
public interface UserDao extends ReactiveMongoRepository<User, String> {

    Flux<User> findUserByUsernameContaining(String username);

}