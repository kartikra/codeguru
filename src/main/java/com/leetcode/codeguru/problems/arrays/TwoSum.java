package com.leetcode.codeguru.problems.arrays;

import com.leetcode.codeguru.ProblemSolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum implements ProblemSolution {
    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
     */

    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[]{-1, -1};
        Map<Integer, Integer> mapPreviousNumber = new HashMap<>();

        for(int i=0; i<nums.length; i++) {

            if (mapPreviousNumber.containsKey(target -nums[i])) {
                result[0] = mapPreviousNumber.get(target -nums[i]);
                result[1] = i;
                return result;
            }
            mapPreviousNumber.put( nums[i], i);

        }

        return result;

    }

    public void validate(){
        assert Arrays.equals(twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2});
        assert Arrays.equals(twoSum(new int[]{3, 3}, 6), new int[]{0, 1});
        logger.info("all test cases passed");
    }
}
