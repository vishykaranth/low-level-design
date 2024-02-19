package com.winterbe.java8.samples.stream.samples;

import java.util.function.Function;

public class FunctionsExamples {

    public static void main(String[] args) {
        Function<String, Integer> toInteger = Integer::valueOf;

        Integer integer = toInteger.apply("123");
        System.out.println(integer);
        System.out.println(toInteger.andThen(String::valueOf).apply("456"));


        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        backToString.apply("123");     // "123"
    }

}
