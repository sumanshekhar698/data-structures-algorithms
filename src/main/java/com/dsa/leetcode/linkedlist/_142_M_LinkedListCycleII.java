package com.dsa.leetcode.linkedlist;

import java.util.HashMap;

public class _142_M_LinkedListCycleII {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public static ListNode detectCycle(ListNode head) {// Super Optimized Solution
        //Floyd's Tortoise and Hare (Cycle Detection) Algorithm

//        There is a slow and fast pointer and slow moves by 1 position and fast moves by two positions
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {//we are using fast as it is reaching first till the end if there is an end, if fast is null then there is no cycle
            slow = slow.next;//slow moves by 1 position
            fast = fast.next.next;//fast moves by 2 position

            if (slow == fast) {//if they meet then there is a cycle
//                if there is a cycle
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }

        return null;//if the loop ends with condition false then there is no cycle
    }


    public ListNode detectCycleUsingHashMap(ListNode head) {

        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;

        int i = 0;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp;
            }
            map.put(temp, i++);
            temp = temp.next;
        }


        return null;
    }

}
