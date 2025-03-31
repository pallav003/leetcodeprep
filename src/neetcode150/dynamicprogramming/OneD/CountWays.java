package neetcode150.dynamicprogramming.OneD;

/**
 * Climbing Stairs
 * Solved
 * You are given an integer n representing the number of steps to reach the top of a staircase. You can climb with either 1 or 2 steps at a time.
 * <p>
 * Return the number of distinct ways to climb to the top of the staircase.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * <p>
 * Output: 2
 * Explanation:
 * <p>
 * 1 + 1 = 2
 * 2 = 2
 * Example 2:
 * <p>
 * Input: n = 3
 * <p>
 * Output: 3
 * Explanation:
 * <p>
 * 1 + 1 + 1 = 3
 * 1 + 2 = 3
 * 2 + 1 = 3
 * Constraints:
 * <p>
 * 1 <= n <= 30
 */
public class CountWays {
    int[] cache;

    public int climbStairs(int n) {
        cache = new int[n];
        return dfs(0, n);
    }

    public int dfs(int i, int n) {
        if (i >= n) return i == n ? 1 : 0;
        if (cache[i] != 0) return cache[i];

        return cache[i] = dfs(i + 1, n) + dfs(i + 2, n);
    }
}
