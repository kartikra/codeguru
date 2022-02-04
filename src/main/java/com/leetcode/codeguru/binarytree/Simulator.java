package com.leetcode.codeguru.binarytree;

public class Simulator {

    public TreeNode mockDataBinaryTree(){

        TreeNode N8 = new TreeNode(8);
        TreeNode N9 = new TreeNode(9);
        TreeNode N4 = new TreeNode(4, N8, N9);

        TreeNode N5 = new TreeNode(5);
        TreeNode N2 = new TreeNode(2, N4, N5);

        TreeNode N6 = new TreeNode(6);
        TreeNode N7 = new TreeNode(7);
        TreeNode N3 = new TreeNode(3, N6, N7);

        TreeNode N1 = new TreeNode(1, N2, N3);

        return N1;
    }
}
