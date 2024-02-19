package com.winterbe.java8tutor;


//@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}


public class FunctionalInterfaceImpl {

    public static void main(String[] args) {
//        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123

    }
}
