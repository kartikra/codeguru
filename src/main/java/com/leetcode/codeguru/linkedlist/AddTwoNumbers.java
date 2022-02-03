package com.leetcode.codeguru.linkedlist;
import com.leetcode.codeguru.ProblemSolution;

public class AddTwoNumbers implements ProblemSolution {

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Head of the new linked list - this is the head of the resultant list
        ListNode resultHead = null;
        // Reference to head which is null at this point
        ListNode resultNext = null;
        // Carry
        int carry = 0;

        // Loop for the two lists
        while (l1 != null || l2 != null) {
            // At the start of each iteration, we should add carry from the last iteration
            int sum = carry;
            // Since the lengths of the lists may be unequal, we are checking if the
            // current node is null for one of the lists
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // At this point, we will add the total sum % 10 to the new node
            // in the resultant list
            ListNode node = new ListNode(sum % 10);
            // Carry to be added in the next iteration
            carry = sum / 10;
            // If this is the first node or head
            if (resultNext == null) {
                resultNext = resultHead = node;
            }
            // For any other node
            else {
                resultNext.next = node;
                // shift by one
                resultNext = resultNext.next;
            }
        }
        // After the last iteration, we will check if there is carry left
        // If it's left then we will create a new node and add it
        if (carry > 0) {
            resultNext.next = new ListNode(carry);
        }
        return resultHead;
    }

    public void validate(){

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 = addTwoNumbers(l1, l2);
        assert(l3.val == 7);
        assert(l3.next.val == 0);
        assert(l3.next.next.val == 8);

        logger.info("All test cases passed!");

    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 = addTwoNumbers(l1, l2);
        System.out.println(l3.val);
        System.out.println(l3.next.val);
        System.out.println(l3.next.val);


    }

    }
