package com.winterchen.fluxmysql.configuration;

import com.winterchen.fluxmysql.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

/**
 * @author CENTURY
 * @version 1.0
 * @date 2021/9/22 16:52
 **/
@Configuration
public class RouterConfiguration {

    @Bean
    RouterFunction<ServerResponse> userRouterFunction(UserHandler userHandler) {
        return RouterFunctions.nest(RequestPredicates.path("/user"),
                RouterFunctions.route(RequestPredicates.GET("/"), userHandler::getAllUsers)
                .andRoute(RequestPredicates.POST("/"), userHandler::addUser)
                .andRoute(RequestPredicates.DELETE("/{id}"), userHandler::deleteUser));
    }

}