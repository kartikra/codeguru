package com.leetcode.codeguru.problems.arrays;
import com.leetcode.codeguru.ProblemSolution;

import java.util.*;

public class FizzBuzz implements ProblemSolution  {
    /*
    Given an integer n, return a string array answer (1-indexed) where:
        answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
        answer[i] == "Fizz" if i is divisible by 3.
        answer[i] == "Buzz" if i is divisible by 5.
        answer[i] == i (as a string) if none of the above conditions are true.
     */

    private List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            String tmpResult = "";
            tmpResult+= (i%3)==0 ? "Fizz": "";
            tmpResult+= (i%5)==0 ? "Buzz": "";
            result.add(tmpResult.isEmpty() ? Integer.toString(i): tmpResult);
        }
        return result;
    }


    public void validate() {

        assert fizzBuzz(3) .equals(Arrays.asList("1", "2", "Fizz"));
        assert fizzBuzz(5) .equals( Arrays.asList("1", "2", "Fizz", "4", "Buzz"));
        assert fizzBuzz(15).equals(Arrays.asList("1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"));
        logger.info("all test cases passed");

    }

}
