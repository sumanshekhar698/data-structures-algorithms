package com.dsa.leetcode.linkedlist;

public class _82RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {

    }

    static ListNode deleteDuplicates(ListNode head) {//removes all the nodes group with duplicates
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = head;

        boolean flagIsHeadRepeated = false;
        while (temp != null && temp.next != null) {//for head duplicate filter
            if (temp.val == temp.next.val) {
                flagIsHeadRepeated = true;
                temp = temp.next;//progressing temp
            } else {
                break;
            }
        }

        if (flagIsHeadRepeated) {
            temp = temp.next;//removing the last duplicate head
            dummy.next = temp;//updating dummy.next
        }


        ListNode previousTemp = temp;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else
                temp = temp.next;
        }

        return dummy.next;


    }

    static ListNode removeDuplicates(ListNode head) {//makes the LinkedList Unique by removing duplicates
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = head;

        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
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
