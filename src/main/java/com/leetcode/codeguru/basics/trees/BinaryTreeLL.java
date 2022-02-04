package com.leetcode.codeguru.basics.trees;

import java.util.List;

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

}
