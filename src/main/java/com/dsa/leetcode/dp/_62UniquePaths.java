package com.dsa.leetcode.dp;

public class _62UniquePaths {

    public static void main(String[] args) {
        int paths = uniquePaths(3, 7);
        System.out.println(paths);
        paths = uniquePathsUsingMaths(3, 5);
        System.out.println(paths);
    }

    public static int uniquePaths(int m, int n) {

//        Using Bottom-Up Approach
        int[][] grid = new int[m + 1][n + 1];//+1 for boundary grid
        grid[m][n - 1] = 1;//end position


        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = grid[i].length - 2; j >= 0; j--) {
//                System.out.print(i + " " + j + "|");
                grid[i][j] = grid[i + 1][j] + grid[i][j + 1];

            }
        }

        //

        return grid[0][0];

    }

    public static int uniquePathsUsingMaths(int m, int n) {
        long numerator = factorial(m - 1 + n - 1);//total moves
        long denominator = factorial(m - 1) * factorial(n - 1);//correction of duplicates
        return (int) (numerator / denominator); // Cast to int for result
    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
