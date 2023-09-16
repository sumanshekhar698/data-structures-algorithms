package com.dsa.leetcode.linkedlist;

public class _21MergeTwoSortedLists {
    //    https://leetcode.com/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(head, head2);

        ListNode dummy = result;

        while (dummy != null) {
            System.out.print(dummy.val + " --> ");
            dummy = dummy.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //this logic works on slicing the two lists and rearranging the links
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;//the head ie list1 will keep on going ahead
            } else {
                current.next = list2;
                list2 = list2.next;//the head ie list2 will keep on going ahead
            }

            current = current.next;//to keep on keeping the current at the last element of the rearranged chain


        }

        if (list1 != null)//edge case to link.append all the remaining elements to the current end
            current.next = list1;
        else
            current.next = list2;

        return dummy.next;//return the link next to dummy

    }


    static class ListNode {
        int val;
        ListNode next;

//        ListNode(int x) {
//            val = x;
//            next = null;
//        }

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
