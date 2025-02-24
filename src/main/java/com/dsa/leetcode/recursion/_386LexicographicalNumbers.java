package com.dsa.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class _386LexicographicalNumbers {
    public static void main(String[] args) {
        int n = 30;
        System.out.println(lexicalOrder3(n));
    }

    private static List<Integer> lexicalOrder1(int n) {//Recursive
        List<Integer> list = new ArrayList<>();

        class DFS {
            void dfs(int current) {
                if (current > n) {
                    return;
                }
                list.add(current);//current is a lexicographical number

                current *= 10;//current is a parent node and we are going to its children nodes
                for (int i = 0; i <= 9; i++) {
                    dfs(current + i);
                }
            }
        }

        DFS dfsObj = new DFS();
        for (int i = 1; i <= 9; i++) {
            dfsObj.dfs(i);// 1 to 9 are the first digits of the lexicographical order
            // So we are starting from 1 to 9 as root nodes and then we are going to the children nodes
        }


        return list;
    }

    private static List<Integer> lexicalOrder2(int n) {//Recursive Enhanced version of the above code
        List<Integer> list = new ArrayList<>();

        class DFS {
            void dfs(int current) {
                if (current > n) {
                    return;
                }

                list.add(current);
                for (int i = 0; i <= 9; i++) {
                    if (10 * current + i <= n) {//Enhancement :: adding the condition
                        // to check if the number is less than n
                        dfs(10 * current + i);
                    }
                }
            }
        }

        DFS dfsObj = new DFS();
        for (int i = 1; i <= 9; i++) {
            dfsObj.dfs(i);// 1 to 9 are the first digits of the lexicographical order
            // So we are starting from 1 to 9 as root nodes,
            // and then we are going to the children nodes
        }


        return list;
    }

    static public List<Integer> lexicalOrder3(int n) {//Best Recursive
        List<Integer> lexicographicalNumbers = new ArrayList<>();
        // Start generating numbers from 1 to 9
        for (int start = 1; start <= 9; ++start) {
            generateLexicalNumbers(start, n, lexicographicalNumbers);
        }
        return lexicographicalNumbers;
    }

    private static void generateLexicalNumbers(int currentNumber, int limit, List<Integer> result) {
        // If the current number exceeds the limit, stop recursion
        if (currentNumber > limit) return;

        // Add the current number to the result
        result.add(currentNumber);

        // Try to append digits from 0 to 9 to the current number
        for (int nextDigit = 0; nextDigit <= 9; ++nextDigit) {
            int nextNumber = currentNumber * 10 + nextDigit;
            // If the next number is within the limit, continue recursion
            if (nextNumber <= limit) {
                generateLexicalNumbers(nextNumber, limit, result);
            } else {
                break; // No need to continue if nextNumber exceeds limit
            }
        }
    }

    private static List<Integer> lexicalOrder4(int n) {//Iterative

        List<Integer> list = new ArrayList<>();
        int current = 1;
        while (list.size() < n) {
            list.add(current);
            if (10 * current <= n) {// if 10*current is less than n
                // then we can go to the children nodes
                current *= 10;
            } else {
                if (current >= n) {// if current is greater than n then we need to go back to the parent node
                    current /= 10;
                }
                current += 1;
                while (current % 10 == 0) {
                    current /= 10;
                }
            }

        }


        return list;
    }

    private static List<Integer> lexicalOrder5(int n) {//Iterative 2

        List<Integer> list = new ArrayList<>();
        int current = 1;
        while (list.size() < n) {
            list.add(current);
            if (10 * current <= n) {// if 10*current is less than n
                // then we can go to the children nodes
                current *= 10;
            } else {
                while (current == n || current % 10 == 9) {
                    current /= 10;
                }
                current += 1;
            }

        }
        return list;
    }


}
