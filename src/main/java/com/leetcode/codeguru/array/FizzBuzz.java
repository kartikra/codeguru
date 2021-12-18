package com.leetcode.codeguru.array;
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

            boolean divisibleBy3 = (i % 3 == 0);
            boolean divisibleBy5 = (i % 5 == 0);

            if (divisibleBy3 && divisibleBy5) {
                // Divides by both 3 and 5, add FizzBuzz
                result.add("FizzBuzz");
            } else if (divisibleBy3) {
                // Divides by 3, add Fizz
                result.add("Fizz");
            } else if (divisibleBy5) {
                // Divides by 5, add Buzz
                result.add("Buzz");
            } else {
                // Not divisible by 3 or 5, add the number
                result.add(Integer.toString(i));
            }
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
