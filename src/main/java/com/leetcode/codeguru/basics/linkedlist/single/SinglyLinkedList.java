package com.leetcode.codeguru.basics.linkedlist.single;

import com.leetcode.codeguru.basics.linkedlist.single.Node;

public class SinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node create(int nodeValue) {
        // this is only called while creating the first element in an empty list

        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    // Insert Method SinglyLinkedList
    public void insertByLocation(int nodeValue, int location) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        if (head == null) {
            // empty list
            create(nodeValue);
            return;
        } else if (location == 0) {
            // add to start of list
            newNode.next = head;
            head = newNode;
        } else if (location >= size) {
            // last element of list. next of newNode is null while tail is previous element of newNode
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        } else {
            // middle of list
            Node currentNode = head;
            int index = 0;
            while (index < location - 1) {
                currentNode = currentNode.next;
                index++;
            }
            Node nextNode = currentNode.next;
            currentNode.next = newNode;
            newNode.next = nextNode;
        }
        size++;
    }

    // SinglyLinkedList Traversal
    public void traverse() {
        if (head == null) {
            System.out.println("SLL does not exist!");
        } else {
            Node currentNode = head;
            for (int i = 0; i<size; i++) {
                System.out.print(currentNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                currentNode = currentNode.next;
            }
        }
        System.out.println("\n");
    }

    // Search for a node
    boolean searchNodeValue(int nodeValue) {
        if (head != null) {
            Node currentNode = head;
            for (int i=0; i<size; i++) {
                if (currentNode.value == nodeValue) {
                    System.out.print("Found the node at location: " +i+"\n");
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        System.out.print("Node not found! ");
        return false;
    }

    //Deleting a node from SinglyLinkedList
    public void deleteNodeInLocation(int location) {
        if (head == null) {
            System.out.println("The SLL does not exist");
            return;
        } else if (location == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        } else if (location >= size) {
            Node currentNode = head;
            for (int i = 0; i < size - 1; i++) {
                currentNode = currentNode.next;
            }
            if (currentNode == head) {
                tail = head = null;
                size--;
                return;
            }
            currentNode.next = null;
            tail = currentNode;
            size--;
        } else {
            Node currentNode = head;
            for (int i = 0; i <location-1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
            size--;
        }
    }

    //  Delete Entire SinglyLinkedList
    public void drop() {
        head = null;
        tail = null;
        size = 0;
        System.out.println("The SLL deleted successfully");

    }

}