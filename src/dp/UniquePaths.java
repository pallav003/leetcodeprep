package dp;

import java.util.Arrays;

/**
 * Unique Paths
 * Solved
 * There is an m x n grid where you are allowed to move either down or to the right at any point in time.
 * <p>
 * Given the two integers m and n, return the number of possible unique paths that can be taken from the top-left corner of the grid (grid[0][0]) to the bottom-right corner (grid[m - 1][n - 1]).
 * <p>
 * You may assume the output will fit in a 32-bit integer.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: m = 3, n = 6
 * <p>
 * Output: 21
 * Example 2:
 * <p>
 * Input: m = 3, n = 3
 * <p>
 * Output: 6
 */
public class UniquePaths {
    int[][] memo;

    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dfs(0, 0, m, n);
    }

    public int dfs(int row, int col, int m, int n) {
        if (row >= m || col >= n) {
            return 0;
        }
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        memo[row][col] = dfs(row + 1, col, m, n) + dfs(row, col + 1, m, n);
        return memo[row][col];
    }
}
