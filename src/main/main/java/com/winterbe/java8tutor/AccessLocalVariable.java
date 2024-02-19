package com.winterbe.java8tutor;

public class AccessLocalVariable {

    public static void main(String[] args) {
//        final int num = 1;
        int num = 1;
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);

        System.out.println(stringConverter.convert(2)); // 3

//        num = 3;
    }
}
