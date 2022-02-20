package com.leetcode.codeguru.basics.trees.bst;

import java.util.List;
import java.util.ArrayList;


public class BinarySearchTreeMain {

    private static void testBST() {

        BinarySearchTree bstTree = new BinarySearchTree();

        System.out.println("preorder: root -> left -> right = ");
        List<Integer> result = bstTree.preOrder(mockData2(), new ArrayList<>());
        System.out.println("\n" + result);

        System.out.println("\ninorder: left -> root -> right = ");
        result = bstTree.inOrder(mockData2(), new ArrayList<>());
        System.out.println("\n" + result);

        System.out.println("\npostorder: left -> right -> root = ");
        result = bstTree.postOrder(mockData2(), new ArrayList<>());
        System.out.println("\n" + result);

        System.out.println("\nlevelorder: 1 level at a time = ");
        result = bstTree.levelOrder(mockData2());
        System.out.println("\n" + result);

        bstTree.search(mockData2(), 50);
        bstTree.search(mockData2(), 200);

        BinaryNode leafNodeDeleted = bstTree.deleteNode(mockData2(), 40);
        System.out.println("\nResult after deleting 40 (leaf node) ");
        result = bstTree.inOrder(leafNodeDeleted, new ArrayList<>());
        System.out.println("\n" + result);

        BinaryNode postDeletionResult = bstTree.deleteNode(leafNodeDeleted, 30);
        System.out.println("\nResult after deleting 30 (had 1 child) ");
        result = bstTree.inOrder(postDeletionResult, new ArrayList<>());
        System.out.println("\n" + result);

        postDeletionResult = bstTree.deleteNode(mockData2(), 30);
        System.out.println("\nResult after deleting 30 (had 2 child) ");
        result = bstTree.inOrder(postDeletionResult, new ArrayList<>());
        System.out.println("\n" + result);


    }

    private static BinaryNode mockData2() {

        BinarySearchTree bstTree = new BinarySearchTree();

        BinaryNode bstTreeNode = bstTree.insertNode(null, 70);
        bstTreeNode = bstTree.insertNode(bstTreeNode, 100);
        bstTreeNode = bstTree.insertNode(bstTreeNode, 50);
        bstTreeNode = bstTree.insertNode(bstTreeNode, 90);
        bstTreeNode = bstTree.insertNode(bstTreeNode, 20);
        bstTreeNode = bstTree.insertNode(bstTreeNode, 60);
        bstTreeNode = bstTree.insertNode(bstTreeNode, 40);
        bstTreeNode = bstTree.insertNode(bstTreeNode, 30);
        bstTreeNode = bstTree.insertNode(bstTreeNode, 80);

        return bstTreeNode;
    }

    public static void main(String[] Args) {

        //testLL();
        // testArray();
        testBST();

    }

}
