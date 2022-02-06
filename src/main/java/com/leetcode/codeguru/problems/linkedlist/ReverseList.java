package com.leetcode.codeguru.problems.linkedlist;

import com.leetcode.codeguru.ProblemSolution;

public class ReverseList implements ProblemSolution {

    public static ListNode reverseList(ListNode head) {

        ListNode following = head;
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            following = following.next;
            current.next = previous;
            previous = current;
            current = following;
        }


        return previous;

    }

    public void validate() {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);

        ListNode l3 = reverseList(l1);
        assert (l3.val == 4);
        assert (l3.next.val == 3);
        assert (l3.next.next.val == 2);
        assert (l3.next.next.next.val == 1);

        logger.info("all test cases passed");

    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode l3 = reverseList(l1);

        System.out.println(l3.val);
        System.out.println(l3.next.val);
        System.out.println(l3.next.next.val);
        System.out.println(l3.next.next.next.val);
        System.out.println(l3.next.next.next.next.val);


    }
}