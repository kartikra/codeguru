package com.leetcode.codeguru.basics.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {

    BinaryNode root;

    public BinaryTreeLL() {
        this.root = null;
    }

    // PreOrder Traversal : (Root -> Left -> Right)
    List<String>  preOrder(BinaryNode node, List<String> result) {
        if (node == null) {
            return result;
        }
        System.out.print(node.value + " ");
        result.add(node.value);
        preOrder(node.left, result);
        preOrder(node.right, result);
        return result;
    }

    // InOrder Traversal : (Left -> Root -> Right)
    List<String> inOrder(BinaryNode node, List<String> result) {
        if (node == null) {
            return result;
        }
        inOrder(node.left, result);
        System.out.print(node.value + " ");
        result.add(node.value);
        inOrder(node.right, result);
        return result;

    }

    // Post Order Traversal : (Left -> Right -> Root)
    List<String> postOrder(BinaryNode node, List<String> result) {
        if (node == null) {
            return result;
        }
        postOrder(node.left, result);
        postOrder(node.right, result);
        System.out.print(node.value + " ");
        result.add(node.value);
        return result;

    }

    List<String> levelOrder(BinaryNode node) {

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(node);
        List<String> result = new ArrayList<>();

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

    // Search Method using level order traversal
    public boolean search(BinaryNode node, String value) {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(node);

        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.value.equals(value)) {
                System.out.println("The value- "+value+" is found in Tree");
                return Boolean.TRUE;
            } else {
                if (presentNode.left!=null) {
                    queue.add(presentNode.left);
                }
                if (presentNode.right!=null) {
                    queue.add(presentNode.right);
                }
            }
        }
        System.out.println("The value- "+value+" is not found in Tree");
        return Boolean.FALSE;
    }

    // Insert Method using level order traversal
    public BinaryNode insert(BinaryNode root, String value) {

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        BinaryNode newNode = new BinaryNode(value);

        while (!queue.isEmpty()) {

            BinaryNode presentNode = queue.remove();

            if (presentNode.left == null) {
                presentNode.left = newNode;
                System.out.println("The value- " + value + " has been added as left node of " + presentNode.value);
                return root;
            } else
            if (presentNode.right == null) {
                presentNode.right = newNode;
                System.out.println("The value- " + value + " has been added as right node of " + presentNode.value);
                return root;
            } else {
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
        return root;
    }

    // Get Deepest node
    private BinaryNode getDeepestNode(BinaryNode root) {

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        BinaryNode presentNode = null;
        while (!queue.isEmpty()) {
            presentNode = queue.remove();
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
        return presentNode;
    }

    // Delete Deepest node
    private void deleteDeepestNode(BinaryNode root) {

        /*


            1      -> present.node.right == null then present.node.left == null (remove 2)
          2
      																				              1   -> previous
            -> present.node.left == null then previous.node.right == null (remove 3)    	    2   3

         */

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        BinaryNode previousNode, presentNode = null;
        while (!queue.isEmpty()) {

            previousNode = presentNode;  // before fetching next, save previous
            presentNode = queue.remove();

            if (presentNode.left == null) {
                previousNode.right = null;
                return;
            } else if (presentNode.right == null) {
                presentNode.left = null;
                return;
            }
            queue.add(presentNode.left);
            queue.add(presentNode.right);

        }
    }

    // Delete Given node
    public BinaryNode deleteNode(BinaryNode root, String value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {    // --> O(N)
            BinaryNode presentNode = queue.remove();
            if (presentNode.value.equals(value)) {  // --> Not N*N because this if condition executed only once
                // get deepest node's value --> O(N)
                presentNode.value = getDeepestNode(root).value;

                // delete deepest node --> O(N)
                deleteDeepestNode(root);
                System.out.println("node found and " + value + " is deleted!");
                return root;
            } else {
                if (presentNode.left != null) queue.add(presentNode.left);
                if (presentNode.right != null) queue.add(presentNode.right);
            }
        }
        System.out.println("The node does not exist in this BT");
        return root;
    }

    // Delete Binary Tree
    void deleteBT(BinaryNode root) {
        root = null;
        System.out.println("BT has been successfully deleted!");
    }


}
