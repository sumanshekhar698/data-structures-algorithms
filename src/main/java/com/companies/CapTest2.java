package com.companies;

import java.util.HashMap;
import java.util.HashSet;

public class CapTest2 {

    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 3, 6, 4};

        int sum = 7;

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        for (int num : arr) {
            if (set.contains(sum - num)) {
                System.out.println(num + " | " + (sum - num));//retrieval
                set.remove(num); //update
                set.remove(sum - num); //update
            }

        }


    }
}


