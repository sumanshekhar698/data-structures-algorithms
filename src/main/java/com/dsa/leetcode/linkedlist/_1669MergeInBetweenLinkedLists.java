package com.dsa.leetcode.linkedlist;

public class _1669MergeInBetweenLinkedLists {

    class Solution {

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

        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            ListNode temp1 = list1;
            ListNode temp2 = list2;

            ListNode breakPoint1 = null, breakPoint2 = null;
            a -= 1;//as we have to break before ath position in list1


            int i = 0;
            while (temp1 != null) {
                if (i == a) {
                    breakPoint1 = temp1;//get the breakPoint1 in list1
                } else if (i == b) {
                    breakPoint2 = temp1;//get the breakPoint2 in list1 and break
                    break;
                }
                temp1 = temp1.next;
                ++i;
            }


            while (temp2.next != null) {//get the end node of list2
                temp2 = temp2.next;
            }


            //merging logic
            breakPoint1.next = list2;
            temp2.next = breakPoint2.next;

            return list1;
        }
    }
}
