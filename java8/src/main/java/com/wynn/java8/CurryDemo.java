package com.wynn.java8;

import java.util.function.Function;

/**
 * 级联表达式和柯里化
 * 柯里化:把多个参数的函数转化为只有一个参数的函数
 * 柯里化的目的:函数标准化
 */
public class CurryDemo {
    public static void main(String[] args) {
        Function<Integer, Function<Integer, Integer>> fun = x -> y -> x + y;
        System.out.println(fun.apply(2).apply(3)); //5
    }
}
