package com.winterbe.dfrog;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Java8Basics {

    public static void main(String[] args) {
//        int[] numbers = {4, 1, 13, 90, 16, 2, 0};
//        int asInt = IntStream.of(numbers).min().getAsInt();
////        System.out.println(asInt);
//        IntStream.of(numbers).min().ifPresent(min -> System.out.println(min));
//        IntStream.of(numbers).min().ifPresent(System.out::println);
//
//
//        System.out.println(IntStream.of(numbers).summaryStatistics());

        first3DistinctSmallestNumbers();

    }

    public static void first3DistinctSmallestNumbers() {
        int[] numbers = {4, 1, 13, 90, 16, 2, 0};
        int[] copy = Arrays.copyOf(numbers, numbers.length);

        Arrays.sort(copy);

        for (int i = 0; i < 3; i++) {
            System.out.println(copy[i]);
        }
    }
}
