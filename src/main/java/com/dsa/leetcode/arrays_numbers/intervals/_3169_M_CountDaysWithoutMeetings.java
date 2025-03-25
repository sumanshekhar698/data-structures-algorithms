package com.dsa.leetcode.arrays_numbers.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class _3169_M_CountDaysWithoutMeetings {


    public static void main(String[] args) {
        int[][] mat = {{3, 4}, {4, 8}, {2, 5}, {3, 8}};
        int days = countDays(8, mat);
        System.out.println(days);


    }

    static public int countDays(int days, int[][] meetings) {

//        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        Arrays.sort(meetings, Comparator.comparingInt(interval -> interval[0]));
        int prevEndDay = -1;//setting this to -1 as there is initially no prevEndDay when you are just about to start


        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            start = Math.max(start, prevEndDay + 1);
            int range = end - start + 1;
            days -= Math.max(range, 0);//subtraction of the non overlapping meeting days


/*        Math.max(range, 0) --> this code handles the case where a interval is dolled in a different interval,
          in that case the startDay will be after end day, resulting to a -ve range.
          so if the range is -ve, this will always result to 0 that is no change in days*/

            prevEndDay = Math.max(prevEndDay, end);

        }

        return days;


    }


    public int countDaysBrute(int days, int[][] meetings) {

        boolean[] daysTracker = new boolean[days + 1];//he is working on all days and false
        // at every place is for no meetings yet

        for (int[] meeting : meetings) {
            Arrays.fill(daysTracker, meeting[0], meeting[1] + 1, true);// true means there is a meeting
        }

        return (int) IntStream.range(1, daysTracker.length)
                .filter(i -> !daysTracker[i])
                .count();

    }
}
