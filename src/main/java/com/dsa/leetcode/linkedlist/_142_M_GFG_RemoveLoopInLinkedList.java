package com.dsa.leetcode.linkedlist;

import java.util.HashSet;
import java.util.HashSet;

public class _142_M_GFG_RemoveLoopInLinkedList {
//    https://www.geeksforgeeks.org/problems/remove-loop-in-linked-list/1

    class Node {
        int data;
        Node next;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    static void printList(Node curr) {
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Function to detect and remove loop in a linked list
    static void removeLoopUsingHashset(Node head) {

        // hash set to hash addresses of
        // the linked list nodes
        HashSet<Node> set = new HashSet<>();

        // pointer to prev node
        Node prev = null;
        Node temp = head;
        while (temp != null) {

            // if node not present in the map,
            // insert it in the map
            if (!set.contains(temp)) {
                set.add(temp);
                prev = temp;
                temp = temp.next;
            }// if present, it is a cycle, make last node's (prev) next pointer NULL
            else {
                prev.next = null;
                break;
            }
        }
    }


    // Function that detects loop in the list OPTIMIZED
    static void removeLoopWrong(Node head) {

        // If list is empty or has only one node
        // without loop
        if (head == null || head.next == null)
            return;

        Node slow = head, fast = head;

        // Move slow and fast 1 and 2 steps
        // ahead respectively.

        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                fast = head;
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;

            }
        }

    }


    // Function that detects loop in the list
    static void removeLoopCORRECT(Node head) {

        // If list is empty or has only one node
        // without loop
        if (head == null || head.next == null)
            return;

        Node slow = head, fast = head;

        // Move slow and fast 1 and 2 steps
        // ahead respectively.
        slow = slow.next;
        fast = fast.next.next;

        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;

            slow = slow.next;
            fast = fast.next.next;
        }

        // If loop exists
        if (slow == fast) {
            slow = head;
            if (slow != fast) {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // since fast->next is the looping point
                // remove loop
                fast.next = null;
            } else { // This case is added if fast and slow pointer meet at first position.
                while (fast.next != slow) {
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
    }


}
