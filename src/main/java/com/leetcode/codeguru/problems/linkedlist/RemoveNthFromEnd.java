package com.leetcode.codeguru.problems.linkedlist;

import com.leetcode.codeguru.ProblemSolution;

public class RemoveNthFromEnd implements ProblemSolution {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        // move fast pointer at n steps. i
        for (int i=0; i < n; i++){

            // Edge Cases:- if end is reaches sooner
            // list of length 2 and n = 2, in these cases advance head by 1
            // list of length 1 and n = 2, return head as is
            if (fastPointer.next == null) {
                return  (i == n - 1)? head.next : head;
            }

            // advance fastPointer by 1 step at a time
            fastPointer = fastPointer.next;

        }

        // fastPointer is n steps ahead
        while (fastPointer.next != null) {
            fastPointer = fastPointer.next; // each time fastPointer is made up of 1 node eg  3 or 4 or 5
            slowPointer = slowPointer.next; // each time slowPointer is made up of 1 node eg - 1 or 2 or 3 or 4 or 5
        }

        if (slowPointer.next != null) {
            slowPointer.next = slowPointer.next.next;  // slowPointer = 3, 5
        }

        // at this point head is whatever was in slowPointer except 4

        return head;
    }

    public void validate(){

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode l2 = removeNthFromEnd(l1, 2);
        assert(l2.val == 1);
        assert(l2.next.val == 2);
        assert(l2.next.next.val == 3);
        assert(l2.next.next.next.val == 5);

        logger.info("all test cases passed");

    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode l2 = removeNthFromEnd(l1, 2);

        /*
        System.out.println(l2.val);
        System.out.println(l2.next.val);
        System.out.println(l2.next.next.val);
        System.out.println(l2.next.next.next.val);
        System.out.println(l2.next.next.next.next.val);
        */

    }
}