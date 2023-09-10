package com.dsa.leetcode.linkedlist;

public class _2AddTwoNumbers {
    //    https://leetcode.com/problems/add-two-numbers/submissions/
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1).next = new ListNode(8).next = new ListNode(4).next = new ListNode(3);
        ListNode l2 = new ListNode(5).next = new ListNode(4).next = new ListNode(6);
        ListNode result = addTwoNumbers(l1, l2);

//        1 7 4 3  reversed equals    3 4 8  1
//          5 4 6  reversed equals +  0  6 4 5
//      --------------------------------------
//                                    4 1 2 6


    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        O(n) time = n
//        O(n) space = max(l1.len,l2.len) + 1

        ListNode dummy = new ListNode();
        ListNode current = dummy;
        ListNode s1 = l1;
        ListNode s2 = l2;
        int carry = 0;


//        1 7 4 3  reversed equals     3 4 7 1
//        5 4 6    reversed equals  +  0 6 4 5
//      ---------------------------------------
//                                     4 1 2 6

//        loop till both the linked list are not null
        while (s1 != null || s2 != null || carry != 0) {//carry != 0 is for the edge case when the last sum is greater than 10 so we will add carry to the sum for one more time which will be add one more digits to the numbers
            int sum = 0;
            if (s1 != null) {
                sum += s1.val;
                s1 = s1.next;
            }
            if (s2 != null) {
                sum += s2.val;
                s2 = s2.next;
            }

            sum += carry;
            carry = sum / 10;//sum/10 will give the carry ie 1 in case of 12


            current.next = new ListNode(sum % 10);//sum%10 will give the last digit of the sum
            current = current.next;
        }

        return dummy.next;


    }

    static public class ListNode {
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
}
