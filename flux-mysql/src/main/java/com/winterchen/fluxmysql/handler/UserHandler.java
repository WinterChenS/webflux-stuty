package com.winterchen.fluxmysql.handler;

import com.winterchen.fluxmysql.entity.User;
import com.winterchen.fluxmysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static java.lang.Long.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

/**
 * @author CENTURY
 * @version 1.0
 * @date 2021/9/22 16:47
 **/
@Component
public class UserHandler {

    @Autowired
    UserRepository userRepository;

    public Mono<ServerResponse> getAllUsers(ServerRequest serverRequest) {
        return ok().contentType(APPLICATION_JSON)
                .body(userRepository.findAll(), User.class);
    }

    public Mono<ServerResponse> addUser(ServerRequest serverRequest) {
        return ok().contentType(APPLICATION_JSON)
                .body(userRepository.saveAll(serverRequest.bodyToMono(User.class)), User.class);
    }

    public Mono<ServerResponse> deleteUser(ServerRequest serverRequest) {
        return userRepository.findById(parseLong(serverRequest.pathVariable("id")))
                .flatMap(user -> userRepository.delete(user).then(ok().build()))
                .switchIfEmpty(notFound().build());
    }

}