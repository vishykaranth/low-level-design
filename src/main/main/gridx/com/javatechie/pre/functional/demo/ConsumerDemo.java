package com.javatechie.pre.functional.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {
        Consumer<Integer> consumer = t -> System.out.println("Printing 1 : " + t);
        Consumer<Integer> consumer2 = t -> System.out.println("Printing 2 : " + t);
        Consumer<Integer> consumer3 = t -> System.out.println("Printing 3 : " + t);
        Consumer<Integer> consumer4 = t -> System.out.println("Printing 4 : " + t);
        Consumer<Integer> consumer5 = t -> System.out.println("Printing 5 : " + t);
        consumer.andThen(consumer2).andThen(consumer3).andThen(consumer4).andThen(consumer5).accept(10);
//        consumer.accept(20);
//        consumer.accept(30);

//		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
//
//		list1.stream().forEach(t -> System.out.println("print  : " + t));

    }
}
