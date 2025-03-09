package com.dsa.leetcode.arrays_numbers.slidingwindow;

public class _2379_E_MinimumRecolorsToGetKConsecutiveBlackBlocks {

    public static void main(String[] args) {
        String block = "WWBBBWBBBBBWWBWWWB";
        System.out.println(minimumRecolors(block, 16));
        System.out.println(minimumRecolorsSelfTry(block, 16));

    }

    static public int minimumRecolors(String blocks, int k) {

        int i = 0, reColor = 0, res = k;

        for (int j = 0; j < blocks.length(); j++) {
            if (blocks.charAt(j) == 'W') {
                reColor++;
            }
            if (j - i + 1 == k) {//We can now slide the window of size k by sliding 1 unit
                res = Math.min(res, reColor);
                if (blocks.charAt(i) == 'W') {
                    reColor--;
                }
                i++;

            }
        }

        return res;

    }

    static public int minimumRecolorsSelfTry(String blocks, int k) {
        int tempWCounter = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                tempWCounter++;
            }
        }


        int minOps = tempWCounter;
        for (int i = 1; i <= blocks.length() - k; i++) {
            char chAtPreviousToBlock = blocks.charAt(i - 1);
            char chAtNextToBlock = blocks.charAt(i + k - 1);

            if (chAtPreviousToBlock == 'W') {
                tempWCounter--;
            }
            if (chAtNextToBlock == 'W') {
                tempWCounter++;
            }

            minOps = Math.min(minOps, tempWCounter);
        }

        return minOps;


    }

}
