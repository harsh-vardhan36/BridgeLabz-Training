package com.exceptionhandling.exceptionpropagation;

public class ExceptionPropagationDemo {

    static void method1() {
        int result = 10 / 0;   // ArithmeticException
    }

    static void method2() {
        method1();            // exception propagates to caller
    }

    public static void main(String[] args) {

        try {
            method2();        // exception reaches here

        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}
