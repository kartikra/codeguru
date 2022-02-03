package com.leetcode.codeguru.basics.linkedlist.circularsingle;

public class MainCircularSinglyLinkedList {

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.create(5);
        csll.insertByLocation(4, 0);
        csll.insertByLocation(6, 1);
        csll.insertByLocation(7, 8);
        csll.traverse();
        csll.drop();
        csll.traverse();

    }
}
