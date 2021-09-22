package com.winterchen.lambda;

import com.winterchen.lambda.model.User2;

/**
 * @author CENTURY
 * @version 1.0
 * @date 2021/9/22 10:39
 **/
public class LambdaDemo03 {

    public static void main(String[] args) {
        User2 user2 = new User2();
        user2.setUsername("winter chen");
        String say = user2.say((username) -> "hello " + username);
        System.out.println("say = " + say);
    }

}