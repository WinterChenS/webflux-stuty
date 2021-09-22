package com.winterchen.fluxrouter.handler;

import com.winterchen.fluxrouter.entity.Person;
import com.winterchen.fluxrouter.respository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

/**
 * @author CENTURY
 * @version 1.0
 * @date 2021/9/22 16:04
 **/
@Component
public class PersonHandler {

    @Autowired
    PersonRepository personRepository;


    public Mono<ServerResponse> addPerson(ServerRequest serverRequest) {
        return ok().contentType(APPLICATION_JSON)
                .body(personRepository.saveAll(serverRequest.bodyToMono(Person.class)), Person.class);
    }

    public Mono<ServerResponse> deletePerson(ServerRequest serverRequest) {
        return personRepository.findById(Long.parseLong(serverRequest.pathVariable("id")))
                .flatMap(p -> personRepository.delete(p).then(ok().build()))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> getAllPerson(ServerRequest serverRequest) {
        return ok().contentType(APPLICATION_JSON)
                .body(personRepository.findAll(), Person.class);
    }

}