package com.winterbe.java8.samples.stream.samples;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicateExamples {
    public static void main(String[] args) {
        Predicate<String> predicate = (s) -> s.length() > 0;

        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();


        String name = "";
        System.out.println(isEmpty.test(name));

    }
}
