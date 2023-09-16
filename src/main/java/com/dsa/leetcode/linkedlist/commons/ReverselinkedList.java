package com.dsa.leetcode.linkedlist.commons;

public class ReverselinkedList {
    //    https://leetcode.com/problems/reverse-nodes-in-k-group/?envType=study-plan-v2&envId=top-interview-150
//    https://www.youtube.com/watch?v=jhm2pYGFIos
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode listNode = reverseLinkedList(head);
    }


    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;//save next
            curr.next = prev;//revrese the link

            // advancing prev & curr
            prev = curr;
            curr = next;//eventually curr will become null
        }

        return null;
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
