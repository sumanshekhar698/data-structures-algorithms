package com.dsa.recursion;

public class FibonacciUsingRecursion {

    public static void main(String[] args) {
        int x = fibo(10);
        System.out.println(x);
    }

    private static int fibo(int i) {
        if (i <= 1)
            return i;

        return fibo(i-1) + fibo(i -2);

    }
}
