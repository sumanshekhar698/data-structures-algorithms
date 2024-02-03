package com.companies;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Kaiser3rdHighestDuplicate {
    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int rank = 3;

        HashMap<Integer, Integer> map = new HashMap<>();//K:V :: num:freq
        Integer[] arr = {2, 24, 18, 2, 2, 14, 14, 8, 18, 9, 14, 24, 24, 19, 18, 24, 25, 2, 2, 14, 14, 91};
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry :map.entrySet()){
            if(entry.getValue()>1){
                queue.add(entry.getKey());
            }
        }

        for (int i = 1; i < rank; i++) {
            queue.poll();
        }

        System.out.println(queue.peek());
    }
}
