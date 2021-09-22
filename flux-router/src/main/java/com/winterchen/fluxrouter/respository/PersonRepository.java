package com.winterchen.fluxrouter.respository;

import com.winterchen.fluxrouter.entity.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author CENTURY
 * @version 1.0
 * @date 2021/9/22 16:03
 **/
@EnableMongoRepositories
public interface PersonRepository extends ReactiveMongoRepository<Person, Long> {



}