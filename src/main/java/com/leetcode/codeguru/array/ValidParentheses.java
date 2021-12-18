package com.leetcode.codeguru.array;

import com.leetcode.codeguru.ProblemSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses implements ProblemSolution {

    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    */

    public static void main(String[] Args){
        logger.info(isValid("[}]"));
    }

    private static boolean isValid(String s) {

        Map<Character, Character> pairParentheses = new HashMap<>();
        pairParentheses.put("{".charAt(0), "}".charAt(0));
        pairParentheses.put("(".charAt(0), ")".charAt(0));
        pairParentheses.put("[".charAt(0), "]".charAt(0));

        ArrayList<Character> syntaxCheck = new ArrayList<>();

        for(char c: s.toCharArray())
        {
            if (pairParentheses.containsKey(c))
                syntaxCheck.add(c);
            else
            {
                // if no start parentheses scanned so far, fail the syntax
                if (syntaxCheck.size() == 0)
                    return Boolean.FALSE;

                char lastValue = syntaxCheck.get(syntaxCheck.size() - 1);
                if (c == pairParentheses.get(lastValue))
                    syntaxCheck.remove(syntaxCheck.size() - 1);
                else
                    return Boolean.FALSE;
            }
        }

        // if string has to be balanced, all characters should have been removed by now
        return (syntaxCheck.size() == 0) ? Boolean.TRUE : Boolean.FALSE;

    }

    public void validate(){

        assert(! isValid("{"));
        assert(! isValid("]"));
        assert(isValid("{}"));
        assert(isValid("[{}]"));
        assert(isValid("{{{(([()]))}}}"));
        assert(! isValid("[{}]("));
        assert(! isValid("[{}]]"));
        logger.info("all test cases passed");

    }
}

