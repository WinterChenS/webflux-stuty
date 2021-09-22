package com.winterchen.flux01.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author CENTURY
 * @version 1.0
 * @date 2021/9/22 13:36
 **/
@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        long start = System.currentTimeMillis();
        String helloStr = getHelloStr();
        log.info("hello api: " + (System.currentTimeMillis() - start));
        return helloStr;
    }


    @GetMapping("/hello2")
    public Mono<String> hello2() {
        long start = System.currentTimeMillis();
        Mono<String> hello2 = Mono.fromSupplier(() -> getHelloStr());
        log.info("Webflux api: " + (System.currentTimeMillis() - start));
        return hello2;
    }

    @GetMapping(value = "/flux",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> flux() {
        Flux<String> flux = Flux.fromArray(new String[]{"javaboy","itboyhub","www.javaboy.org","itboyhub.com"}).map(s -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "my->data->" + s;
        });
        return flux;
    }


    private String getHelloStr() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return "hello";
    }

}