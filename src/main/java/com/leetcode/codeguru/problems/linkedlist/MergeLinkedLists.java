package com.leetcode.codeguru.problems.linkedlist;

import com.leetcode.codeguru.ProblemSolution;

public class MergeLinkedLists implements ProblemSolution {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Check if ant of the lists are null
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        // Head of the result list
        ListNode head;
        // Pointer for the resultant list
        ListNode temp;
        // Choose head which is smaller of the two lists
        if (list1.val < list2.val) {
            temp = head = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            temp = head = new ListNode(list2.val);
            list2 = list2.next;
        }
        // Loop until any of the list becomes null
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            temp = temp.next;
        }
        // Add all the nodes in l1, if remaining
        while (list1 != null) {
            temp.next = new ListNode(list1.val);
            list1 = list1.next;
            temp = temp.next;
        }
        // Add all the nodes in l2, if remaining
        while (list2 != null) {
            temp.next = new ListNode(list2.val);
            list2 = list2.next;
            temp = temp.next;
        }
        return head;

    }

    public void validate(){

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = mergeTwoLists(l1, l2);
        assert(l3.val == 1);
        assert(l3.next.val == 1);
        assert(l3.next.next.val == 2);
        assert(l3.next.next.next.val == 3);
        assert(l3.next.next.next.next.val == 4);
        assert(l3.next.next.next.next.next.val == 4);
        logger.info("All test cases passed!!");
    }
}
