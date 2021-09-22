package com.winterchen.lambda.model;

import lombok.Data;

import java.util.function.Function;

/**
 * @author CENTURY
 * @version 1.0
 * @date 2021/9/22 10:39
 **/
@Data
public class User2 {

    private String username;

    public String say(Function<String, String> sayHello) {
        return sayHello.apply(this.username);
    }

}