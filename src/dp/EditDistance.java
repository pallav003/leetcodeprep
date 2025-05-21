package dp;

import java.util.Arrays;

/**
 * 72. Edit Distance
 * Solved
 * Medium
 * Topics
 * Companies
 * Given two strings word1 and word2, return the minimum number of
 * operations required to convert word1 to word2.
 * <p>
 * You have the following three operations permitted on a word:
 * <p>
 * Insert a character
 * Delete a character
 * Replace a character
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 * <p>
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * <p>
 * <p>
 *
 *
 * Constraints:
 * <p>
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 */
public class EditDistance {
    int[][] dp;

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }

        return editDistance(word1, word2, m, n);
    }

    public int editDistance(String s1, String s2, int m, int n) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            dp[m][n] = editDistance(s1, s2, m - 1, n - 1);
            return dp[m][n];
        }
        dp[m][n] = 1 + Math.min(
                editDistance(s1, s2, m - 1, n), Math.min(
                        editDistance(s1, s2, m - 1, n - 1),
                        editDistance(s1, s2, m, n - 1)
                )
        );
        return dp[m][n];
    }
}
