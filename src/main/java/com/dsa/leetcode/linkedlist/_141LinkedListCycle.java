package com.dsa.leetcode.linkedlist;

import java.util.HashSet;


public class _141LinkedListCycle {
//    https://leetcode.com/problems/linked-list-cycle/

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;//Loop Created  [3 -> >2 -> 0 -> 4 -]
        System.out.println(hasCycle(head));
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public static boolean hasCycleUsingHashSet(ListNode head) {

        //        O(n) time = n
        //        O(n) space = n

        HashSet<ListNode> set = new HashSet<>();
        ListNode dummy = head;

        while (dummy != null) {//If there is a loop it will already be there in the HashSet
            if (set.contains(dummy))
                return true;
            else
                set.add(dummy);

            dummy = dummy.next;
        }

        return false;


    }

    public static boolean hasCycle(ListNode head) {// Super Optimized Solution
        //Floyd's Tortoise and Hare (Cycle Detection) Algorithm

//        This works because, we are preyty sure that if there is a cycle then slow and fast will meet at some point
//  Also they will meet somewhere in the cycle SO the gap betweeen fast and slow becomes smaller and smaller by every iteration
//        Say the gap is 10 in the first iteration then it will be 9 (10 + 1 slow -2 fast) in the next iteration and so on
//        if (head == null || head.next == null)//for zero or single node with no cycles
//            return false;

        //        O(n) time = n
        //        O(1) space = 1

//        There is slow and fast pointer and slow moves by 1 position and fast moves by two position
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {//we are using fast as it is reaching first till the end if there is an end, if fast is null then there is no cycle
            slow = slow.next;//slow moves by 1 position
            fast = fast.next.next;//fast moves by 2 position

            if (slow == fast)//if they meet then there is a cycle
                return true;
        }

        return false;//if the loop ends with condition false then there is no cycle
    }

}
