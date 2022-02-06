package com.leetcode.codeguru.problems.linkedlist;

import com.leetcode.codeguru.ProblemSolution;

// 92

public class ReverseList2 implements ProblemSolution {

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode following = head;
        ListNode current = head;

        ListNode leftOfRange = null;
        ListNode range = null;
        ListNode rightOfRange = null;

        int currentPosition = 1;

        while (current != null) {

            following = following.next;

            if (currentPosition < left) {
                if (currentPosition == 1)
                    leftOfRange = head;
                else {
                    leftOfRange.next = current;
                    leftOfRange = leftOfRange.next;
                }

            }

            if (currentPosition == left)
                rightOfRange = current;

            if (currentPosition >= left & currentPosition <= right) {
                current.next = range;
                range = current;
            }

            leftOfRange.next = range;


            if (currentPosition == right) {
                System.out.println(leftOfRange.val);
                System.out.println(leftOfRange.next.val);
                System.out.println(leftOfRange.next.next.val);
                System.out.println(leftOfRange.next.next.next.val);

            }


            if (currentPosition > right) {
                rightOfRange.next = current;
                rightOfRange = rightOfRange.next;
            }

            currentPosition += 1;
            current = following;
        }

        return rightOfRange;

    }

    public void validate() {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);

        ListNode l3 = reverseBetween(l1, 3, 4);
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

        ListNode l3 = reverseBetween(l1, 2, 4);

        /*
        System.out.println(l3.val);
        System.out.println(l3.next.val);
        System.out.println(l3.next.next.val);
        System.out.println(l3.next.next.next.val);
        System.out.println(l3.next.next.next.next.val);
        */

    }
}