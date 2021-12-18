package com.leetcode.codeguru.array;
import com.leetcode.codeguru.ProblemSolution;

import java.util.Arrays;


public class ProductArrayExceptSelf implements ProblemSolution {

    /*
      Given an integer array nums, return an array answer such that answer[i]
      is equal to the product of all the elements of nums except nums[i].

      HINT - For any element i, result is (left side of i) * (right side of i)
     */

    private int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }

    public void validate(){
        assert Arrays.equals(productExceptSelf(new int[]{1, 2, 3, 4}), new int[]{24, 12, 8, 6});
        assert Arrays.equals(productExceptSelf(new int[]{-1, 1, 0, -3, 3}), new int[]{0, 0, 9, 0, 0});
        logger.info("all test cases passed");
    }


}
