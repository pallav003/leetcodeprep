package dp;

/**
 * Longest Increasing Subsequence
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * <p>
 * A subsequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the relative order of the remaining characters.
 * <p>
 * For example, "cat" is a subsequence of "crabt".
 * Example 1:
 * <p>
 * Input: nums = [9,1,4,2,3,3,7]
 * <p>
 * Output: 4
 * Explanation: The longest increasing subsequence is [1,2,3,7], which has a length of 4.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,3,1,3,2,3]
 * <p>
 * Output: 4
 * Constraints:
 * <p>
 * 1 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 */
public class LongestIncreasingSubsequence {
// o (n * n) lis solution
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max + 1;
    }
}
