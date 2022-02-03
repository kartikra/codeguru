package com.leetcode.codeguru.linkedlist;

public class RemoveDupsSorted {

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
        ListNode result = null;
        ListNode resultHead = null;

        while (current != null){
            ListNode temp = current;
            int count = 0;
            while(temp !=null && temp.val == current.val) {
                count += 1;
                temp = temp.next;
            }
            System.out.println(temp.val + " : " + count);

            // Set current node next to the next unique element denoted by temp
            if (count == 1)
            {
                ListNode node = new ListNode(temp.val);
                if (result == null)
                {
                    result = resultHead = node;
                } else {
                    result.next = node;
                    result = result.next;
                }
            }
            current = current.next;
        }

        return resultHead;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);

        ListNode l2 = deleteDuplicatesAll(l1);

        /*
        System.out.println(l2.val);
        System.out.println(l2.next.val);
        System.out.println(l2.next.next.val);
        System.out.println(l2.next.next.next.val);
        */

    }
}
