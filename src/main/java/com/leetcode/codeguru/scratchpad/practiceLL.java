package com.leetcode.codeguru.scratchpad;

import java.util.Arrays;
import java.util.HashSet;

public class practiceLL {

    public static ListNode reverseList(ListNode head){

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

    public static ListNode addTwoLists(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode resultHead = null;
        int overflow = 0;

        while (l1 != null || l2 != null) {

            int sum = overflow;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            int digit = sum % 10;
            overflow = sum / 10;

            if (result == null)
                result = resultHead = new ListNode(digit);
            else {
                result.next = new ListNode(digit);
                result = result.next;
            }

        }

        if (overflow > 0)
            result.next = new ListNode(overflow);

        return resultHead;
    }

    public static ListNode removeDupSorted(ListNode head) {

        ListNode current = head;

        while (current != null) {

            ListNode temp = current;
            while (temp != null && temp.val == current.val) {
                temp = temp.next;
            }

            current.next = temp;
            current = current.next;
        }

        return head;
    }

    public static ListNode removeDupUnsorted(ListNode head) {

        /*
        2 -> 3 -> 2 -> 4 -> 5 -> 5 -> 7 -> 2

        prev 2 -> 3

        current: 2
        prev.next = current.next 2 -> 3 -> 4

         */

        ListNode current = head;
        ListNode prev = null;
        HashSet<Integer> existing = new HashSet<>();

        while (current != null) {

            int value = current.val;

            if (existing.contains(value)) {
                // prev already has current value. shift to next
                prev.next = current.next;
            }
            else {
                existing.add(value);
                // prev follows current
                prev = current;
            }
            current = current.next;
        }

        return head;
    }

    public static ListNode removeNFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;

        for (int i=1; i <= n; i++) {

            // Edge Cases:- if end is reaches sooner,
            // Example: list of length 2 and n = 2, in these cases advance head by 1
            // Example: list of length 1 and n = 2, return head as is
            if (fast.next == null) {
                return  (i == n)? head.next : head;
            }

            fast = fast.next;
        }

        // note:- checking fast.next and not fast
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (slow.next != null)      // Edge Case: check added for n = 0
            slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] Args) {

        DataSimulator simulator = new DataSimulator();
        ListNode testNode = simulator.generateListDataInt(Arrays.asList(7, 2, 3, 4, 5, 5, 1, 3, 2));
        System.out.println("original -> ");
        simulator.printListData(testNode);

        ListNode result = removeDupUnsorted(testNode);
        System.out.println("Remove Dups from UnSorted -> ");
        simulator.printListData(result);

        int n = 0;
        result = removeNFromEnd(testNode, n);
        System.out.println("Remove " + n + " from end -> ");
        simulator.printListData(result);


        /*
        ListNode result = reverseList(testNode);
        System.out.println("reversed -> ");
        simulator.printListData(result);

        ListNode l1 = simulator.generateListDataInt(Arrays.asList(3, 2, 1));
        ListNode l2 = simulator.generateListDataInt(Arrays.asList(8, 5, 4));
        result = addTwoLists(l1, l2);
        System.out.println("sum -> ");
        simulator.printListData(result);

        */


    }
}
