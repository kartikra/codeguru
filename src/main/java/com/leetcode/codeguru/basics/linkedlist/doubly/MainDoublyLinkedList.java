package com.leetcode.codeguru.basics.linkedlist.doubly;

public class MainDoublyLinkedList {

    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.create(1);
        dll.insertByLocation(2, 0);
        dll.insertByLocation(3, 1);
        dll.insertByLocation(4, 7);
        dll.traverse();
        dll.reverseTraverse();
        dll.drop();
        dll.traverse();
    }

}
