package dp;

import java.util.Arrays;

/**
 * 509. Fibonacci Number
 * Solved
 * Easy
 * Topics
 * Companies
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * <p>
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 * <p>
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 30
 */
public class FibonacciNumber {
    private int[] memo;

    public int fib(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fibHelper(n);
    }

    public int fibHelper(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = fibHelper(n - 1) + fibHelper(n - 2);
        return memo[n];
    }
}
