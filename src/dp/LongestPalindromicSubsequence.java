package dp;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 * <p>
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consists only of lowercase English letters.
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int[][] memo = new int[s.length()][s.length()];

        return lps(0, s.length() - 1, memo, s);
    }

    public int lps(int low, int high, int[][] memo, String s) {
        if (low > high) return 0;
        if (low == high) return memo[low][high] = 1;
        if (memo[low][high] != 0) return memo[low][high];
        if (s.charAt(low) == s.charAt(high)) {
            return memo[low][high] = lps(low + 1, high - 1, memo, s) + 2;
        }

        return memo[low][high] = Math.max(
                lps(low, high - 1, memo, s), lps(low + 1, high, memo, s)
        );
    }
}
