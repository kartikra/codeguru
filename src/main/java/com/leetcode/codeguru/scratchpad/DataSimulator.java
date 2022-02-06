package com.leetcode.codeguru.scratchpad;


import java.util.List;

public class DataSimulator {

    public ListNode generateListDataInt(List<Integer> values) {

        ListNode result = null;
        ListNode resultHead = null;

        for (int i: values) {
            if (result == null)
                result = resultHead = new ListNode(i);
            else
            {
                result.next = new ListNode(i);
                result = result.next;
            }
        }
        return resultHead;
    }

    public void printListData(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.print("\n");
    }

    public BinaryNode generateBinaryTreeData(){

        BinaryNode N8 = new BinaryNode(8);
        BinaryNode N9 = new BinaryNode(9);
        BinaryNode N4 = new BinaryNode(4, N8, N9);

        BinaryNode N5 = new BinaryNode(5);
        BinaryNode N2 = new BinaryNode(2, N4, N5);

        BinaryNode N6 = new BinaryNode(6);
        BinaryNode N7 = new BinaryNode(7);
        BinaryNode N3 = new BinaryNode(3, N6, N7);

        BinaryNode N1 = new BinaryNode(1, N2, N3);

        return N1;
    }
}
