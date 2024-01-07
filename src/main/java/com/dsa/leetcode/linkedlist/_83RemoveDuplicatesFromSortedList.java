package com.dsa.leetcode.linkedlist;

import java.util.HashSet;

public class _83RemoveDuplicatesFromSortedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {

        public ListNode deleteDuplicatesOnlyFOrSorted(ListNode head) {//Code for Unsorted will work here
            if (head == null || head.next == null)
                return head;

//            O(n) time = n
//            O(n) space = 1

            ListNode temp = head;
            ListNode dummy = new ListNode(-1);
            dummy.next = temp;
            ListNode prevTemp = dummy;

            while (temp != null && temp.next != null) {
                if (temp.val != temp.next.val) {
                    prevTemp = temp;
                } else {//Deletion and Relinking
                    prevTemp.next = temp.next;
                }

                temp = temp.next;
            }

            return dummy.next;
        }

        public ListNode deleteDuplicatesCAnHandleUnSortedToo(ListNode head) {//Code for Unsorted will work here
            if (head == null || head.next == null)
                return head;

            //            O(n) time = n
            //            O(n) space = n

            HashSet<Integer> set = new HashSet();
            ListNode temp = head;
            ListNode dummy = new ListNode(-1);
            dummy.next = temp;
            ListNode prevTemp = dummy;

            while (temp != null) {
                if (!set.contains(temp.val)) {
                    set.add(temp.val);
                    prevTemp = temp;
                    //	temp= temp.next;
                } else {//Deletion and Relinking
                    prevTemp.next = temp.next;
                    //	temp = prevTemp.next;
                }
                temp = temp.next;
            }

            return dummy.next;
        }
    }
}
