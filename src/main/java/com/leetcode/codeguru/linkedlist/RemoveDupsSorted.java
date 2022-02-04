package com.leetcode.codeguru.linkedlist;

import com.leetcode.codeguru.ProblemSolution;
import com.leetcode.codeguru.ProblemSolution;

public class RemoveDupsSorted implements ProblemSolution {

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;

        while (current != null){
            ListNode temp = current;
            while(temp !=null && temp.val == current.val) {
                temp = temp.next;
            }

            // Set current node next to the next unique element denoted by temp
            current.next = temp;
            current = current.next;
        }

        return head;
    }

    public static ListNode deleteDuplicatesAll(ListNode head) {

        ListNode current = head;

        // Create a dummy head for prev
        //ListNode prevHead = new ListNode(0);
        // prevHead.next = head;
        ListNode prev = head;

        while (current != null ){

            while (current.next != null &&
                    prev.next.val == current.next.val)
                current = current.next;

            // If current has unique value i.e current is not updated,
            // Move the prev pointer to next node
            if (prev.next == current)
                // When current is updated to the last duplicate value of that segment,
                // make prev the next of current
                prev = prev.next;
            else
                prev.next = current.next;

            current = current.next;
        }

        return head;
    }

    public void validateRemoval(){

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);

        ListNode l2 = deleteDuplicatesAll(l1);
        assert(l2.val == 1);
        assert(l2.next.val == 2);
        assert(l2.next.next.val == 4);

        logger.info("all test cases passed");

    }

    public void validate(){

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);

        ListNode l3 = deleteDuplicates(l1);
        assert(l3.val == 1);
        assert(l3.next.val == 2);
        assert(l3.next.next.val == 3);
        assert(l3.next.next.next.val == 4);

        logger.info("all test cases passed");

    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(3);

        ListNode l2 = deleteDuplicatesAll(l1);

        System.out.println(l2.val);
        System.out.println(l2.next.val);
        System.out.println(l2.next.next.val);

    }
}
