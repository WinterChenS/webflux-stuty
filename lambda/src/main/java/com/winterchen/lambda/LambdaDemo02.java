package com.winterchen.lambda;

import com.winterchen.lambda.interfaces.SayHello;
import com.winterchen.lambda.model.User;

/**
 * @author CENTURY
 * @version 1.0
 * @date 2021/9/22 10:35
 **/
public class LambdaDemo02 {

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("winter chen");
        String say = user.say((username) -> "hello " + username);
        System.out.println("say = " + say);
    }

}