package com.leetcode.codeguru.linkedlist;

import java.util.HashSet;

public class RemoveDupsNotSorted {


    public static ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;
        ListNode prev = null;

        HashSet<Integer> currentValues = new HashSet<>();

        while (current != null){
            if (currentValues.contains(current.val)) {
                prev.next = current.next;
            } else {
                currentValues.add(current.val);
                prev = current;
            }
            current = current.next;
        }

        return head;
    }


    public static void main(String[] args) {

        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);

        ListNode l2 = deleteDuplicates(l1);

        System.out.println(l2.val);
        System.out.println(l2.next.val);
        System.out.println(l2.next.next.val);
        System.out.println(l2.next.next.next.val);


    }
}
