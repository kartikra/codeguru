package com.leetcode.codeguru.basics.trees;

public class BinaryNode {
    public String value;
    public BinaryNode left;
    public BinaryNode right;
    public int height;

    BinaryNode(String value) { this.value = value; }
    BinaryNode(String value, BinaryNode left, BinaryNode right)
    { this.value = value; this.left=left; this.right=right;}

}
