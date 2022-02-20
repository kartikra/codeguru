package com.leetcode.codeguru.basics.trees.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    BinaryNode root;

    public BinarySearchTree() {
        this.root = null;
    }

     // Insert Method
     BinaryNode insertNode(BinaryNode currentNode, int value) {
        if (currentNode == null) {
            BinaryNode newNode = new BinaryNode(value);
            // System.out.println("The value successfully inserted");
            return newNode;
        } else if (value <= currentNode.value) {
            currentNode.left = insertNode(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insertNode(currentNode.right, value);
            return currentNode;
        }
    }

    // Search Method
    BinaryNode search(BinaryNode node, int value) {
        if (node == null ) {
            System.out.println("Value: "+ value+ " not found in BST");
            return null;
        } else if (node.value == value) {
            System.out.println("Value: "+ value+ " found in BST");
            return node;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    // [Same as any BT] PreOrder Traversal : (Root -> Left -> Right)
    List<Integer> preOrder(BinaryNode node, List<Integer> result) {
        if (node == null) {
            return result;
        }
        System.out.print(node.value + " ");
        result.add(node.value);
        preOrder(node.left, result);
        preOrder(node.right, result);
        return result;
    }

    // Most Important [Same as any BT] InOrder Traversal : (Left -> Root -> Right)
    List<Integer> inOrder(BinaryNode node, List<Integer> result) {
        if (node == null) {
            return result;
        }
        inOrder(node.left, result);
        System.out.print(node.value + " ");
        result.add(node.value);
        inOrder(node.right, result);
        return result;

    }

    // [Same as any BT]  Post Order Traversal : (Left -> Right -> Root)
    List<Integer> postOrder(BinaryNode node, List<Integer> result) {
        if (node == null) {
            return result;
        }
        postOrder(node.left, result);
        postOrder(node.right, result);
        System.out.print(node.value + " ");
        result.add(node.value);
        return result;

    }

    // [Same as any BT]
    List<Integer> levelOrder(BinaryNode node) {

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(node);
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {

            BinaryNode presentNode = queue.remove();

            System.out.print(presentNode.value + " ");
            result.add(presentNode.value);

            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
        return result;
    }

    // Minimum node
    public static BinaryNode minimumNode(BinaryNode root) {
        /*
        Keep traversing to left
         */
        if (root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    // Delete node
    public BinaryNode deleteNode(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("Value not found in BST");
            return null;
        }
        if (value < node.value) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNode(node.right, value);
        } else {
            // Node to be deleted has 2 children
            if (node.left != null && node.right != null) {
                BinaryNode temp = root;
                // find minimum value in right subtree
                BinaryNode minNodeForRight = minimumNode(temp.right);
                node.value = minNodeForRight.value;
                // delete the node that was moved up
                node.right = deleteNode(node.right, minNodeForRight.value);
            } else if (node.left != null) {  // node has only a left child
                node = node.left;
            } else if (node.right != null) { // node has only a right child
                node = node.right;
            } else { // node is a leaf node
                node = null;
            }
        }
        return node;

    }

    public void deleteBST() {
        root = null;
        System.out.println("BST has been deleted successfully");
    }



}
