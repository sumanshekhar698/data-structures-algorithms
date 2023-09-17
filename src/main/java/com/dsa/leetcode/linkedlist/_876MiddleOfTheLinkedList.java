package com.dsa.leetcode.linkedlist;

public class _876MiddleOfTheLinkedList {
//    https://leetcode.com/problems/middle-of-the-linked-list/
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode listNode = middleNode(head);
        System.out.print(listNode.val);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow_ptr = head;
        ListNode fast_ptr = head;

        while (fast_ptr != null && fast_ptr.next != null) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }

        return slow_ptr;

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
