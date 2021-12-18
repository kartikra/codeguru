package com.leetcode.codeguru.basics;
import com.leetcode.codeguru.ProblemSolution;

import java.util.*;


public class DemoArray implements ProblemSolution {


    private ArrayList<String> solution(int n) {

        ArrayList<String> testArray = new ArrayList<>();

        for (int i=0; i<=n; i++) {
            testArray.add(Integer.toString(i));
        }

        ArrayList<String> testArrayRead = new ArrayList(Arrays.asList("a", "b", "c"));
        for (String s : testArrayRead) {
            logger.info(s);
        }

        String[] listChar = new String[5];
        listChar[0] = "abc";

        return testArray;
    }


    public void validate(){

        assert solution(5).equals(Arrays.asList("0", "1", "2", "3", "4", "5"));
        assert solution(3).equals(Arrays.asList("0", "1", "2", "3"));
        //assert solution(3).equals(Arrays.asList("0", "1", "2"));
        logger.info("all test cases passed");

    }



}
