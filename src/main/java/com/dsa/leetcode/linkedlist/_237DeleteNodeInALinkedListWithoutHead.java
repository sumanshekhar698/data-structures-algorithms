package com.dsa.leetcode.linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class _237DeleteNodeInALinkedListWithoutHead {
    //    https://leetcode.com/problems/delete-node-in-a-linked-list/description/
    public void deleteNode(ListNode node) {

        //Copy the value from the next node to current node
        node.val = node.next.val;


// Remove the next node from the linkedlist
        node.next = node.next.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

