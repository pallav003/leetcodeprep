package dp;

import java.util.Arrays;

/**
 * Longest Common Subsequence
 * Given two strings text1 and text2, return the length of the longest common subsequence between the two strings if one exists, otherwise return 0.
 * <p>
 * A subsequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the relative order of the remaining characters.
 * <p>
 * For example, "cat" is a subsequence of "crabt".
 * A common subsequence of two strings is a subsequence that exists in both strings.
 * <p>
 * Example 1:
 * <p>
 * Input: text1 = "cat", text2 = "crabt"
 * <p>
 * Output: 3
 * Explanation: The longest common subsequence is "cat" which has a length of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: text1 = "abcd", text2 = "abcd"
 * <p>
 * Output: 4
 * Example 3:
 * <p>
 * Input: text1 = "abcd", text2 = "efgh"
 * <p>
 * Output: 0
 */
public class LongestCommonSubsequence {
    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(m + " " + n);
        return dfs(text1, text2, m - 1, n - 1);
    }

    public int dfs(String a, String b, int m, int n) {
        if (m == -1 || n == -1) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (a.charAt(m) == b.charAt(n)) {
            dp[m][n] = 1 + dfs(a, b, m - 1, n - 1);
            return dp[m][n];
        }
        dp[m][n] = Math.max(dfs(a, b, m - 1, n), dfs(a, b, m, n - 1));
        return dp[m][n];

    }

}
