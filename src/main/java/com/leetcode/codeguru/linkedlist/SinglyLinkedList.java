package com.leetcode.codeguru.linkedlist;

public class SinglyLinkedList {

    public ListNode head;
    public ListNode tail;
    public int size;

    public void create(int nodeValue) {
        ListNode newNode = new ListNode();
        newNode.val = nodeValue;
        newNode.next = null;
        head = newNode;
        tail = newNode;
        size = 1;
    }

    public void insertNodeAtEnd(int nodeValue) {
        if (head == null) {
            create(nodeValue);
            return;
        }
        ListNode newNode = new ListNode();
        newNode.val = nodeValue;
        newNode.next = null;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void traverse() {
        ListNode currentNode = head;
        for (int i =0; i<size; i++) {
            System.out.print(currentNode.val);
            if (i != size -1) {
                System.out.print(" -> ");
            }
            currentNode = currentNode.next;
        }
        System.out.println("\n");
    }

}
