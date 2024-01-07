package com.hackerrank.algorithms.problemsolving.easy;

import java.util.Random;


class VersionControl {

    String versionHistory;

    boolean isBadVersion(int version) {//API that return The current version is BAD or not
        //Logic to find if the current version is BAD
//        Random random = new Random(); // Create a Random object
//        return random.nextBoolean(); // Generate and return a random boolean value

        char character = versionHistory.charAt(version - 1);  // Adjust for zero-based indexing
        if (character == 'g') {
            return false;  // Found a 'g' at an odd index
        }
        return false;
    }
    

}

class VersionControlBADVersionProblem extends VersionControl {
    public int firstBadVersion(int n) {//TODO  1 to n


//	bb
//	gggggbbb
        int i = 1, j = n;
        while (i <= j) {//O(log n)
            int mid = (i + j) / 2;
            if (isBadVersion(mid)) {
                if (mid == 1 || !isBadVersion(mid - 1))
                    return mid;
                else {
                    j = mid - 1;
                }
            } else {
                i = mid + 1;
            }
        }

        return -1;//no bad version is detected

    }
}
