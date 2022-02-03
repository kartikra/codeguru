package com.leetcode.codeguru.basics.linkedlist.circularsingle;

public class CircularSinglyLinkedList {

    public Node head;
    public Node tail;
    public int size;

    public Node create(int nodeValue) {
        
        Node node = new Node();
        node.value = nodeValue;
        node.next = node;
        head = node;
        tail = node;   
        size = 1;
        return head;
    }
    //  Insertion Method
    public void insertByLocation(int nodeValue, int location) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        if (head == null) {
            create(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            head = newNode;
            tail.next = head;    // change for CSLL
        } else if (location >= size) {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            Node currentNode = head;
            int index = 0;
            while (index < location-1) {
                currentNode = currentNode.next;
                index++;
            }
            Node nextNode = currentNode.next;
            currentNode.next = newNode;
            newNode.next = nextNode;
        }
        size++;
    }

    // Traversal Method
    public void traverse() {
        if (head != null) {
            Node currentNode = head;
            for (int i=0; i<size; i++) {
                System.out.print(currentNode.value);
                if (i != size-1) {
                    System.out.print(" -> ");
                }
                currentNode = currentNode.next;
            }
            System.out.println("\n");
        } else {
            System.out.println("\nCSLL does not exist!");
        }
    }

    // Search Method

    public boolean searchByValue(int nodeValue) {
        if (head != null) {
            Node currentNode = head;
            for(int i =0; i<size; i++) {
                if (currentNode.value == nodeValue) {
                    System.out.print("Found node at location: " + i);
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        System.out.println("Node not found! ");
        return false;
    }

    // Delete Method

    public void deleteByLocation(int location) {
        if (head == null) {
            System.out.println("The CSLL does not exist! ");
            return;
        } else if (location == 0) {
            head = head.next;
            tail.next = head;
            size--;
            if (size == 0) {
                tail = null;
                head.next = null;
                head = null;
            }
        } else if (location >= size) {
            Node currentNode = head;
            for (int i =0; i<size-1; i++) {
                currentNode = currentNode.next;
            }
            if (currentNode == head) {
                head.next = null;
                tail = head = null;
                size--;
                return;
            }
            currentNode.next = head;
            tail = currentNode;
            size--;
        } else {
            Node currentNode = head;
            for (int i=0; i < location-1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
            size--;
        }
    }

    // Delete CSLL
    public void drop() {
        if (head == null) {
            System.out.println("The CSLL does not exist!");
        } else {
            head = null;
            tail.next = null;
            tail = null;
            System.out.println("The CSLL has been deleted!");
        }
    }

}
