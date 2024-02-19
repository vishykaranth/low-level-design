package com.winterbe.java8tutor;

interface Formula {
    default double calculate(int a) {
        return 0;
    }

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}