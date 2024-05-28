package com.dsa.leetcode.linkedlist;


public class _143ReorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(head);
        reorderList(head);
        System.out.println(head);


    }


    static public void reorderList(ListNode head) {
        //alternate reordering


//            0, n, 1, n-1 ....
//            1. store the list in a ArrayList and then try

//            2.1 Find Mid-Point
        ListNode midNode = findMid(head);

//            2.2 reverse the 2nd half
        ListNode secondHalfReversed = reverseLinkedList(midNode.next);
        midNode.next = null;

//            so we have 2 LL, head and secondHalfReversed

//            2.3 Surgery
        ListNode tempHead = head;
        while (secondHalfReversed != null) {//the second half is the limiting factor qas in odd len case it will be short
            ListNode temp1 = tempHead.next;
            ListNode temp2 = secondHalfReversed.next;

            //reordering
            tempHead.next = secondHalfReversed;
            secondHalfReversed.next = temp1;

            //progressing our ops
            tempHead = temp1;
            secondHalfReversed = temp2;


        }


    }


    static ListNode findMid(ListNode node) {
        ListNode slow = node, fast = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;//save next
            curr.next = prev;//reverse the link

            // advancing prev & curr
            prev = curr;
            curr = next;//eventually curr will become null
        }

        return prev;
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

        @Override
        public String toString() {
            ListNode temp = this;
            String str = "";
            while (temp != null) {
                str += (temp.val + " -> ");
                temp = temp.next;
            }

            str += "null";
            return str;


        }
    }

}