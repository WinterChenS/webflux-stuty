package com.winterchen.fluxrouter.configuration;

import com.winterchen.fluxrouter.handler.PersonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author CENTURY
 * @version 1.0
 * @date 2021/9/22 16:12
 **/
@Configuration
public class RouterConfiguration {

    @Bean
    RouterFunction<ServerResponse> personRouter(PersonHandler personHandler) {
        return RouterFunctions
                .nest(RequestPredicates.path("/person"),
                        RouterFunctions.route(RequestPredicates.POST("/"), personHandler::addPerson)
                .andRoute(RequestPredicates.GET("/"), personHandler::getAllPerson)
                .andRoute(RequestPredicates.DELETE("/{id}"), personHandler::deletePerson));
    }

}