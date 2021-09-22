package com.winterchen.fluxmysql.repository;

import com.winterchen.fluxmysql.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author CENTURY
 * @version 1.0
 * @date 2021/9/22 16:46
 * @description TODO
 **/
public interface UserRepository extends ReactiveCrudRepository<User, Long> {


}