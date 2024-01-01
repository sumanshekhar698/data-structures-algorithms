package com.dsa.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _23MergeKSortedLists {
    public static void main(String[] args) {

    }


    //    O(n) * logk  where log k is no of levels in the merge sort calltree
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        List<ListNode> convertedNodeLists = Arrays.stream(lists).collect(Collectors.toList());

        while (convertedNodeLists.size() > 1) {
            ArrayList<ListNode> tempNodeLists = new ArrayList<>();


            for (int i = 0; i < convertedNodeLists.size(); i += 2) {
                ListNode l1 = convertedNodeLists.get(i);
                ListNode l2 = i + 1 < convertedNodeLists.size() ? convertedNodeLists.get(i + 1) : null;
                ListNode mergedListNode = mergeTwoLists(l1, l2);
                tempNodeLists.add(mergedListNode);
            }
            convertedNodeLists = tempNodeLists;
        }
        return convertedNodeLists.get(0);
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
