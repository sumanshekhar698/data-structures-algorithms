package com.dsa.leetcode.linkedlist;

public class _92ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

//   1 -> 2 -> 3 ->4 ->5
        ListNode listNode = reverseBetween(head, 2, 4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }


    public static ListNode reverseBetween(ListNode head, int left, int right) {
        //   1 -> 2 -> 3 ->4 ->5  | L:2 R:4
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode leftPrev = dummy;
        ListNode curr = head;


//       Phase::1 reachine leftMost node
        for (int i = 1; i <= left - 1; i++) {//if L = 3,as curr is already 1t 1, so we will move L-1 steps
            leftPrev = curr;
            curr = curr.next;
        }//curr reached left and leftPrev just before current

        //   LP 1 ->[ C2 -> 3 -> 4R] ->5  | L:2 R:4

//        Phase::2 reversal L-R
        ListNode prev = null;
        for (int i = 1; i <= right - left + 1; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }

//        Phase::3 Connections mapping
        leftPrev.next.next = curr;
        leftPrev.next = prev;

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
