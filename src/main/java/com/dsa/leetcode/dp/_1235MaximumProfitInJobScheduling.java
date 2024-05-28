package com.dsa.leetcode.dp;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _1235MaximumProfitInJobScheduling {

    public static void main(String[] args) {

        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};

        int result = jobScheduling(startTime, endTime, profit);
        System.out.println(result);

    }


    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {//nlogn *nlogn

        List<List<Integer>> intervals = IntStream.range(0, startTime.length)
                .mapToObj(i -> Arrays.asList(startTime[i], endTime[i], profit[i]))
//                .sorted((a, b) -> Integer.compare(a.get(0), b.get(0)))  // Sort by start time (index 0)
                .sorted(Comparator.comparingInt(a -> a.get(0)))  // Sort by start time (index 0)
                .collect(Collectors.toList());

        HashMap<Integer, Integer> cache = new HashMap<>();


        class DFS {

            int dfs(int i) {
                int result = 0;
                //Base cases
                if (i == intervals.size())
                    return 0;
                else if (cache.containsKey(i))
                    return cache.get(i);


                //Case 1: Don't Include the current interval
                result = dfs(i + 1);

                //Case 2: Include the current interval
//                    Get the immediate right interval where start time >= current end time


//                int j = i + 1;
//                while (j < intervals.size()) {//n time
//                    if (intervals.get(j).get(0) >= intervals.get(i).get(1)) //start time of j should be less than or equal to the end time of an i interval
//                        break;
//                    j++;
//                }

                // Find the first interval starting after i's end time using binary search
//                int j = Collections.binarySearch(intervals.subList(i + 1, intervals.size()), intervals.get(i).get(1), (a, b) -> Integer.compare(a.get(0), b));
//                 Handle negative result (insert position)
//                j = j < 0 ? -j - 1 : j;


                // Custom binary search using while loop to enhance performance
                int left = i + 1;
                int right = intervals.size() - 1;

                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (intervals.get(mid).get(0) >= intervals.get(i).get(1)) {
                        right = mid - 1;//we will bring right as close as possible
                    } else {
                        left = mid + 1;
                    }
                }

                // j represents the immediate first interval starting after i's end time
                int j = left;


                result = Integer.max(result, (intervals.get(i).get(2) + dfs(j)));
                //updating the grand result as a max of [ result(without including) & current element + next result from next greater partition]
                cache.put(i, result);//memoization
                return result;
            }


        }


        return new DFS().dfs(0);


    }
}
