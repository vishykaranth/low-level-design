package com.winterbe.java8.samples.lambda;

/**
 * @author Benjamin Winterberg
 */
public class Interface1 {

    interface Formula {
        double calculate(int a);

        default double sqrt(int a) {
            return Math.sqrt(positive(a));
        }

        static int positive(int a) {
            return a > 0 ? a : 0;
        }
    }

    public static void main(String[] args) {
        Formula formula1 = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        double calculate = formula1.calculate(100);// 100.0
        double sqrt = formula1.sqrt(-23);// 0.0
        int positive = Formula.positive(-4);// 0.0

        System.out.println(calculate);
        System.out.println(sqrt);
        System.out.println(positive);

//        Formula formula2 = (a) -> sqrt( a * 100);
    }

}