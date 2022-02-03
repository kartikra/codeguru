package com.leetcode.codeguru.basics.linkedlist.single;

class Main {
    public static void main(String[] args) {
        SinglyLinkedList sLL = new SinglyLinkedList();
        sLL.create(5);
        // System.out.println(sLL.head.value);
        sLL.insertByLocation(6, 1);
        sLL.insertByLocation(7, 3);
        sLL.insertByLocation(8, 4);
        sLL.insertByLocation(9, 0);
        sLL.traverse();
        sLL.drop();
        sLL.traverse();

        /*
        5
        5 -> 6 -> 7 -> 8
        9 -> 5 -> 6 -> 7 -> 8
         */
    }
}