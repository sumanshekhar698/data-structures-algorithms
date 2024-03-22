package com.dsa.leetcode.strings;

public class _1963MinimumNumberOfSwapsToMakeTheStringBalanced {

    public static void main(String[] args) {
        String s = "]]][[[[]";
        int result = minSwaps(s);
        System.out.println(result);
    }

    private static int minSwaps(String s) {//the idea is to find the number of open and close brackets
        if (s == null || s.length() == 0 || s.length() % 2 != 0)
            return 0;
        //the data should start with open bracket in ideal case and the close brackets are the menace
        int close = 0, maxClose = 0;//maxClose is 0 as we are assuming it's a default value

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '[') {
                close -= 1;
            } else {
                close += 1;
            }

            maxClose = Integer.max(close, maxClose);//because higher than 1 in the closing bracket has to be swapped

        }

        //each swap gets rid of two extra closing brackets
        //3 --swap-> 1 --swap-> 0
        return (maxClose + 1) / 2;// ]]] doing one swap will be []] so 3 close brackets become 1 close bracket onm a single swap
    }
}
