package com.example.flux.rest;

import com.example.flux.entity.User;
import com.example.flux.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author CENTURY
 * @version 1.0
 * @date 2021/9/22 14:20
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDao userDao;

    @PostMapping("")
    public Mono<User> addUser(@RequestBody User user) {
        return userDao.save(user);
    }

    @GetMapping("/all")
    public Flux<User> getAll() {
        return userDao.findAll();
    }

    @GetMapping(value = "/stream/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> streamAll() {
        return userDao.findAll();
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
        return userDao.findById(id)
                .flatMap(user -> userDao.delete(user)
                        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("")
    public Mono<ResponseEntity<User>> update(@RequestBody User user) {
        return userDao.findById(user.getId())
                .flatMap(u -> userDao.save(user))
                .map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/byname")
    public Flux<User> getUserByName(String name) {
        return userDao.findUserByUsernameContaining(name);
    }


}