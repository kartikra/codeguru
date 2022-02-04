package com.leetcode.codeguru.binarytree;
import com.leetcode.codeguru.ProblemSolution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InorderTraversal implements ProblemSolution {

    public List<Integer> inorderTraversal(TreeNode root) {

        return inOrder(root, new ArrayList<>());

    }

    List<Integer> inOrder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return result;
        }
        inOrder(node.left, result);
        result.add(node.val);
        inOrder(node.right, result);
        return result;

    }

    public void validate(){
        Simulator simulator = new Simulator();
        TreeNode testNode = simulator.mockDataBinaryTree();
        List<Integer>  result = inOrder(testNode, new ArrayList<>());
        logger.info(result);
        assert (result.equals(Arrays.asList(8, 4, 9, 2, 5, 1, 6, 3, 7)));
        logger.info("all test cases passed");
    }

}
