package com.dsa.leetcode.linkedlist;

public class _25ReverseNodesInKGroup {
    //    https://leetcode.com/problems/reverse-nodes-in-k-group/?envType=study-plan-v2&envId=top-interview-150
//    https://www.youtube.com/watch?v=jhm2pYGFIos
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode listNode = reverseKGroupRajnishPepCoding(head, 2);
    }



    static ListNode th = null, tt = null;
    //Easiest and Simplest
    public static ListNode reverseKGroupRajnishPepCoding(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;

        int length = findLength(head);
        ListNode curr = head;
        ListNode oh = null, ot = null;

        while (length >= k) {
            int tempK = k;
            while (tempK-- > 0) {
                ListNode forward = curr.next;
                curr.next = null;
                addNodeAtStart(curr);
                curr = forward;//advancing the List
            }

            if (oh == null) {
                oh = th;
                ot = tt;
            } else {
                ot.next = th;
                ot = tt;

            }
            th = null;
            tt = null;
            length -= k;
        }

        ot.next = curr;
        return oh;

    }



    public static void addNodeAtStart(ListNode node) {
        if (th == null) {
            th = node;
            tt = node;
        } else {
            node.next = th;
            th = node;
        }
    }

    public static int findLength(ListNode head) {
//        https://www.youtube.com/watch?v=EKgNMFCShO8
        ListNode current = head;

        int length = 0;
        while (current != null) {//as dummy -> head
            current = current.next;
            ++length;
        }

        return length;

    }


    //    ****************************************************************************************
    public static ListNode reverseKGroupStriver(ListNode head, int k) {

        if (head == null || head.next == null || k == 1)
            return head;


        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        ListNode next = dummy;
        ListNode previous = dummy;


        int countOfNodes = 0;
        while (current.next != null) {//as dummy -> head
            current = current.next;
            ++countOfNodes;
        }


        while (countOfNodes >= k) {//till we have groups of size k

//            for every k groups
//            - previous will be one node before the group,
//            - current will the 1st
//            - and next will be at 2nd (next of current) of it
            current = previous.next;//setting the current
            next = current.next;// setting next of current

            for (int i = 1; i < k; i++) {//k-1 times as 3 nodes will have 2 unlinking
                current.next = next.next;//3rd node
                next.next = previous.next;
                previous.next = next;
                next = current.next;
            }
            previous = current;
            countOfNodes -= k;

        }

        return dummy.next;

    }

    public ListNode reverseKGroupSuperOptimized(ListNode head, int k) {
        //TODO
        ListNode begin;
        if (k == 1 || head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        begin = dummy;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next, next, first, prev = begin;
        first = curr;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
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
