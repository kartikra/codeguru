package com.leetcode.codeguru.basics.trees.bst;

public class BinaryNode {
    public int value;
    public BinaryNode left;
    public BinaryNode right;
    public int height;

    BinaryNode(int value) { this.value = value; }
    BinaryNode(int value, BinaryNode left, BinaryNode right)
    { this.value = value; this.left=left; this.right=right;}

}
