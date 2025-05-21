package dp;

import java.util.Arrays;

/**
 * House Robber II
 * Solved
 * You are given an integer array nums where nums[i] represents the amount of
 * money the ith house has. The houses are arranged in a circle, i.e.
 * the first house and the last house are neighbors.
 * <p>
 * You are planning to rob money from the houses, but you cannot rob
 * two adjacent houses because the security system will automatically alert
 * the police if two adjacent houses were both broken into.
 * <p>
 * Return the maximum amount of money you can rob without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,4,3]
 * <p>
 * Output: 4
 * Explanation: You cannot rob nums[0] + nums[2] = 6 because nums[0] and nums[2] are adjacent houses. The maximum you can rob is nums[1] = 4.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,9,8,3,6]
 * <p>
 * Output: 15
 * Explanation: You cannot rob nums[0] + nums[2] + nums[4] = 16 because nums[0] and nums[4] are adjacent houses. The maximum you can rob is nums[1] + nums[4] = 15.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class HouseRobberII {
    int[] dp;

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        int max1 = robHelper(nums, dp, 0, nums.length - 1);
        Arrays.fill(dp, -1);
        int max2 = robHelper(nums, dp, 1, nums.length);
        return Math.max(max1, max2);
    }

    public int robHelper(int[] nums, int[] dp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (dp[start] != -1) return dp[start];

        dp[start] = Math.max(nums[start] + robHelper(nums, dp, start + 2, end),
                robHelper(nums, dp, start + 1, end));
        return dp[start];

    }
}
