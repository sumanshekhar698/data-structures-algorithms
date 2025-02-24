package com.dsa.leetcode.arrays_numbers.two_pointers;

import java.util.ArrayList;
import java.util.List;

public class _241DifferentWaysToAddParentheses {

    public static void main(String[] args) {

        String expression = "2*3-4*5";
        List<Integer> integers = diffWaysToCompute(expression);
        System.out.println(integers);

    }


    public static List<Integer> diffWaysToCompute2(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); ++i) {
            char oper = expression.charAt(i);
            if (oper == '+' || oper == '-' || oper == '*') {
                List<Integer> s1 = diffWaysToCompute2(expression.substring(0, i));
                List<Integer> s2 = diffWaysToCompute2(expression.substring(i + 1));
                for (int a : s1) {
                    for (int b : s2) {
                        if (oper == '+') res.add(a + b);
                        else if (oper == '-') res.add(a - b);
                        else if (oper == '*') res.add(a * b);
                    }
                }
            }
        }
        if (res.isEmpty()) res.add(Integer.parseInt(expression));
        return res;
    }

    static public List<Integer> diffWaysToCompute(String expression) {

//        n* 2^n
        class Operations {
            int add(int a, int b) {
                return a + b;
            }

            int sub(int a, int b) {
                return a - b;
            }

            int mul(int a, int b) {
                return a * b;
            }

            int operation(Character operator, int a, int b) {
                switch (operator) {
                    case '+':
                        return add(a, b);
                    case '-':
                        return sub(a, b);
                    case '*':
                        return mul(a, b);
                }
                return 0;
            }

            ArrayList<Integer> backtracking(int left, int right) {
                ArrayList<Integer> res = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    char c = expression.charAt(i);
                    if (c == '+' || c == '-' || c == '*') {// if its operator
                        ArrayList<Integer> leftRes = backtracking(left, i - 1);// i is being skipped as it is operator
                        ArrayList<Integer> rightRes = backtracking(i + 1, right);
                        for (int l : leftRes) {
                            for (int r : rightRes) {
                                res.add(operation(c, l, r));
                            }
                        }
                    }


                }

                if (res.size() == 0) {//if the size is 0 that means there is no operator in the expression, and it is a number
                    res.add(Integer.parseInt(expression.substring(left, right + 1)));//right+1 as substring is exclusive
                }
                return res;

            }

        }

        Operations ops = new Operations();
        ArrayList<Integer> res = ops.backtracking(0, expression.length() - 1);
        return res;

    }


}
