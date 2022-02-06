package com.leetcode.codeguru.basics.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeMain {

    private static void testLL() {

        BinaryTreeLL binaryTree = new BinaryTreeLL();

        System.out.println("preorder: root -> left -> right = ");
        List<String> result = binaryTree.preOrder(mockData(), new ArrayList<>());
        System.out.println("\n" + result);

        System.out.println("\ninorder: left -> root -> right = ");
        result = binaryTree.inOrder(mockData(), new ArrayList<>());
        System.out.println("\n" + result);

        System.out.println("\npostorder: left -> right -> root = ");
        result = binaryTree.postOrder(mockData(), new ArrayList<>());
        System.out.println("\n" + result);

        System.out.println("\nlevelorder: 1 level at a time = ");
        result = binaryTree.levelOrder(mockData());
        System.out.println("\n" + result);

        System.out.println(binaryTree.search(mockData(), "N5"));
        System.out.println(binaryTree.search(mockData(), "N0"));

        BinaryNode rootPostInsert = binaryTree.insert(mockData(), "N10");
        result = binaryTree.levelOrder(rootPostInsert);
        System.out.println("\n" + result);

        BinaryNode rootPostDelete = binaryTree.deleteNode(rootPostInsert, "N5");
        result = binaryTree.levelOrder(rootPostDelete);
        System.out.println("\n" + result);

    }

    private static void testArray() {

        BinaryTreeArray binaryTree = new BinaryTreeArray(9);
        binaryTree.insert("N1");  // 1
        binaryTree.insert("N2");  // 2  LC of 1  2x
        binaryTree.insert("N3");  // 3  RC of 1  2x + 1                           1
        binaryTree.insert("N4");  // 4  LC of 2                     2                       3
        binaryTree.insert("N5");  // 5  RC of 2             4               5           6       7
        binaryTree.insert("N6");  // 6  LC of 3         8       9
        binaryTree.insert("N7");  // 7  RC of 3
        binaryTree.insert("N8");  // 7  LC of 4
        binaryTree.insert("N9");  // 7  RC of 4

        System.out.println("preorder: root -> left -> right = ");
        binaryTree.preOrder(1);
        System.out.println("\ninorder: left -> root -> right = ");
        binaryTree.inOrder(1);
        System.out.println("\npostorder: left -> right -> root = ");
        binaryTree.postOrder(1);
        System.out.println("\nlevelorder: 1 level at a time = ");
        binaryTree.levelOrder();
        System.out.print("\n");

        binaryTree.search( "N5");
        binaryTree.search("N0");

    }


    private static BinaryNode mockData(){

        BinaryNode N8 = new BinaryNode("N8");
        BinaryNode N9 = new BinaryNode("N9");
        BinaryNode N4 = new BinaryNode("N4", N8, N9);

        BinaryNode N5 = new BinaryNode("N5");
        BinaryNode N2 = new BinaryNode("N2", N4, N5);

        BinaryNode N6 = new BinaryNode("N6");
        BinaryNode N7 = new BinaryNode("N7");
        BinaryNode N3 = new BinaryNode("N3", N6, N7);

        BinaryNode N1 = new BinaryNode("N1", N2, N3);

        return N1;
    }

    public static void main(String[] Args) {

        testLL();
        testArray();
    }

}
