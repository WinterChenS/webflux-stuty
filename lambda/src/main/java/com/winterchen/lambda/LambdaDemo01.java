package com.winterchen.lambda;

import com.winterchen.lambda.interfaces.ICalculator;

/**
 * @author CENTURY
 * @version 1.0
 * @date 2021/9/22 10:31
 **/
public class LambdaDemo01 {

    public static void main(String[] args) {
        ICalculator ic = i -> i * i;
        int square = ic.square(5);
        System.out.println(square);
    }

}