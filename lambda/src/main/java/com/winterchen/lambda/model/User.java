package com.winterchen.lambda.model;

import com.winterchen.lambda.interfaces.SayHello;
import lombok.Data;

import java.util.function.Function;

/**
 * @author CENTURY
 * @version 1.0
 * @date 2021/9/22 10:34
 **/
@Data
public class User {

    private String username;


    public String say(SayHello sayHello) {
        return sayHello.sayHello(this.username);
    }



}