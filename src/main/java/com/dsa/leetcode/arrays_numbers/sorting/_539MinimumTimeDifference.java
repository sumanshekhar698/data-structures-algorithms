package com.dsa.leetcode.arrays_numbers.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class _539MinimumTimeDifference {


    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();

        if (n > 1440) {//24 * 60 = 1440
            return 0; // More than 1440 time points are impossible
        }

        // Convert time points to minutes
        List<Integer> minutes = new ArrayList<>(n);
        for (String timePoint : timePoints) {//converting time point to minutes
            String[] parts = timePoint.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutesPart = Integer.parseInt(parts[1]);
            minutes.add(hours * 60 + minutesPart);
        }

        // Sort the minutes for efficient comparison
        Collections.sort(minutes);

        // Handle the case where the smallest and largest time points wrap around midnight
        minutes.add(minutes.get(0) + 1440);

        // Find the minimum difference between adjacent time points
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < minutes.size(); i++) {
            minDiff = Math.min(minDiff, minutes.get(i) - minutes.get(i - 1));
        }

        return minDiff;
    }

    public int findMinDifferenceUsingBucketSort(List<String> timePoints) {
        int n = timePoints.size();

        if (n > 1440) {//24 * 60 = 1440
            return 0; // More than 1440 time points are impossible
        }

        boolean[] bucket = new boolean[1440];

        // Convert time points to minutes

        int firstTimePoint = Integer.MAX_VALUE, lastTimePoint = 0;
        for (String timePoint : timePoints) {//converting time point to minutes
            String[] parts = timePoint.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutesPart = Integer.parseInt(parts[1]);
            int totalMinutes = hours * 60 + minutesPart;
            firstTimePoint = Math.min(firstTimePoint, totalMinutes);
            lastTimePoint = Math.max(lastTimePoint, totalMinutes);
            if (bucket[totalMinutes]) {
                return 0;
            } else {
                bucket[totalMinutes] = true;
            }
        }

        int minDiff = 60 * 24 + firstTimePoint - lastTimePoint;
        // Find the minimum difference between adjacent time points
        int prevTimepoint = firstTimePoint;

        for (int i = firstTimePoint + 1; i < bucket.length; i++) {
            if (bucket[i]) {
                minDiff = Math.min(minDiff, i - prevTimepoint);
                prevTimepoint = i;
            }

        }

        return minDiff;
    }
}