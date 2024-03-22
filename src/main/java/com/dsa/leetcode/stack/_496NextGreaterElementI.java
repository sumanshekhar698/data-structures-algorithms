package com.dsa.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class _496NextGreaterElementI {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2}, nums3 = {2, 1, 3, 4};
        System.out.println(Arrays.toString(nextGreaterElementBrute(nums1, nums3)));
        System.out.println(Arrays.toString(nextGreaterElementOld(nums1, nums3)));
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums3)));
    }

    static public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        //O(n) = n+m
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);//to avoid flag logic

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();//nums[i]:i
        for (int i = 0; i < nums1.length; i++) {//enriching map
            map.put(nums1[i], i);
        }


        ArrayDeque<Integer> stack = new ArrayDeque<>();//STACK it wil contain only thos element whose ngl has to taken out
        //ie the elements in nums1
        // it will always be in increasing order

        for (int i = 0; i < nums2.length; i++) {
            int current = nums2[i];
            while (!stack.isEmpty() && current > stack.peekLast()) {
                Integer popped = stack.removeLast();//all the popped elements have the ngl as the current element
                res[map.get(popped)] = current;//assigning the current to indexes

            }
            if (map.containsKey(current))//only adding the elements to the stack whose ngl has to be found
                stack.addLast(current);
        }


        return res;
    }

    static public int[] nextGreaterElementOld(int[] nums1, int[] nums2) {
        int[] nge = new int[nums1.length];
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = nums2.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();// we are popping until we get nge for current nums2[i] until the stack has some value
            }

            // enriching the hashMap
            if (!stack.isEmpty())
                hashMap.put(nums2[i], stack.peek());
            else
                hashMap.put(nums2[i], -1);

            stack.push(nums2[i]);// Pushing the current element in the stack
            // stack will always remain in increasing order
        }

        for (int i = 0; i < nums1.length; i++) {
            nge[i] = hashMap.get(nums1[i]);
        }
        return nge;
    }

    static public int[] nextGreaterElementBrute(int[] nums1, int[] nums2) {

//        O(n) = n*m
        int[] ngeArray = new int[nums1.length];
        Arrays.fill(ngeArray, -1);//to avoid flag logic
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();//nums[i]:i
        for (int i = 0; i < nums1.length; i++) {//enriching map
            map.put(nums1[i], i);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {//checking only if nums2[i] has a corresponding key in map
//                boolean flag = false;
                for (int j = i + 1; j < nums2.length; j++) {//search for nge
                    if (nums2[j] > nums2[i]) {//if found nge
                        ngeArray[map.get(nums2[i])] = nums2[j];//storing the nge in ngeArray
//                        flag = true;
                        break;
                    }
                }
//                if (flag == false)
//                    nge[hashMap.get(nums2[i])] = -1;
            } else {
                continue;
            }

        }


        return ngeArray;
    }
}
