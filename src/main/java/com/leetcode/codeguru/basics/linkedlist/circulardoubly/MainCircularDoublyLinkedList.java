package com.leetcode.codeguru.basics.linkedlist.circulardoubly;

public class MainCircularDoublyLinkedList {

    public static void main(String[] args) {
        CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();
        cdll.create(1);
        cdll.insertNode(2, 0);
        cdll.insertNode(3, 2);
        cdll.insertNode(4, 5);
        cdll.traversal();
        cdll.reverseTraversal();
        cdll.drop();
        cdll.traversal();
    }
}
