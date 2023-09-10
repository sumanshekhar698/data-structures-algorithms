package com.dsa.leetcode.linkedlist;

public class _19RemoveNthNodeFromEndOfList {
    //    https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        removeNthFromEndOptimized(head, 2);

        while (head.next != null) {
            System.out.println(head.val + "->");
            head = head.next;
        }


    }

    public static ListNode removeNthFromEndNaive(ListNode head, int n) {

//        O(n) time = 2n
//        O(n) space = 1


        ListNode dummy;
        dummy = head;

        int lengthOfLinkedList = 0;
        while (dummy != null) {// 1. Calculating the length of linked List [PASS 1]
            dummy = dummy.next;
            ++lengthOfLinkedList;
        }

        dummy = head;
        if (n == lengthOfLinkedList) {//2.1 EDGE case if len == n ::  remove the 1st HEAD node
            head = head.next;
        } else {
            int targetMinus1 = lengthOfLinkedList - n;// target where we will relink the node links
            int i = 1;
            while (i != targetMinus1) {//2.2 reach to len - n node [PASS 2]
                dummy = dummy.next;
                ++i;
            }

            dummy.next = dummy.next.next; // Update the Node Links

        }

        return head;
//        We can even try a BRUTE reversing the Linked List adn removing the nth node from beginning
    }

    public static ListNode removeNthFromEndOptimized(ListNode head, int n) {

//        O(n) time = n
//        O(n) space = 1

//        if (head.next == null && n == 1)// Linked List SIZE is 1 ,and we have to remove the HEAD node
//            return null;

        ListNode dummy = new ListNode();
        dummy.next = head; // this is the trick to avoid the edge case of removing the head node
        ListNode fastNavigator = dummy;
        ListNode nth = dummy;


//        for (int i = 1; i <= n + 1; i++) {
        for (int i = 1; i <= n; i++) {//placing fastNavigator at n || we can visualize the logic via reset engineering the BRUTE logic
            fastNavigator = fastNavigator.next;
        }

//        while (fastNavigator != null) {// nth.next != null as we want to stop the fastNavigator at the node before the target node
        while (fastNavigator.next != null) {// nth.next != null as we want to stop the fastNavigator at the node before the target node
            fastNavigator = fastNavigator.next;
            nth = nth.next;
        }

        nth.next = nth.next.next;
        return dummy.next;


    }

    static class ListNode {
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




