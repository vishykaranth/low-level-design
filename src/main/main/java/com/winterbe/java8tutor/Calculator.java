package com.winterbe.java8tutor;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Calculator {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println(names);
        sort05(names);
        System.out.println(names);
    }

    private static void sort01(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

    }

    private static void sort02(List<String> names) {
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
    }

    private static void sort03(List<String> names) {
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
    }

    private static void sort04(List<String> names) {
        Collections.sort(names, (a, b) -> b.compareTo(a));
    }

    private static void sort05(List<String> names) {
        Collections.sort(names, Comparator.reverseOrder());
    }
}
