package com.leetcode.codeguru.basics.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeMain {

    public static void main(String[] Args) {
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
}
