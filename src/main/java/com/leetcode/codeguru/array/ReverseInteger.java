package com.leetcode.codeguru.array;
import com.leetcode.codeguru.ProblemSolution;


public class ReverseInteger implements ProblemSolution {

    private int reverse(int x) {

        int  sign = (x < 0) ? -1 : 1;
        x = Math.abs(x);
        int reverseValue = 0;

        while(x > 0)
        {
            int digit = x % 10;
            // Identifying digit overflow
            if ((reverseValue > Integer.MAX_VALUE/10) ||
                    (reverseValue == Integer.MAX_VALUE/10 && digit > (Integer.MAX_VALUE%10)))
                    return 0;
            else
                reverseValue = (reverseValue * 10) + digit;
            x /= 10;
        }

        return reverseValue * sign;
    }

    public void validate(){
        assert(reverse(321) == 123);
        assert(reverse(120) == 21);
        assert(reverse(-123) == -321);
        assert(reverse(1534236469) == 0);
        logger.info("all test cases passed");

    }
}
