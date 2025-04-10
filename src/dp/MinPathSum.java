package dp;

import java.util.Arrays;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 * <p>
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 200
 */
public class MinPathSum {

    int[][] dp;

    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0, grid);
    }

    public int dfs(int m, int n, int[][] grid) {
        if (m == grid.length - 1 && n == grid[0].length - 1) {
            return grid[m][n];
        }
        if (m >= grid.length || n >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        dp[m][n] = grid[m][n] + Math.min(dfs(m + 1, n, grid),
                dfs(m, n + 1, grid));
        return dp[m][n];
    }
}
