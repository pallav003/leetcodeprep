package dp;

import java.util.Arrays;

/**
 * House Robber
 * Solved
 * You are given an integer array nums where nums[i] represents the amount of money the ith house has. The houses are arranged in a straight line, i.e. the ith house is the neighbor of the (i-1)th and (i+1)th house.
 * <p>
 * You are planning to rob money from the houses, but you cannot rob two adjacent houses because the security system will automatically alert the police if two adjacent houses were both broken into.
 * <p>
 * Return the maximum amount of money you can rob without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,3,3]
 * <p>
 * Output: 4
 * Explanation: nums[0] + nums[2] = 1 + 3 = 4.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,9,8,3,6]
 * <p>
 * Output: 16
 * Explanation: nums[0] + nums[2] + nums[4] = 2 + 8 + 6 = 16.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class HouseRobber {
    //memoization

    int[] dp;

    public int rob(int[] nums) {
        dp = new int[nums.length + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return dfs(nums, 0);
    }

    public int dfs(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != Integer.MIN_VALUE) {
            return dp[index];
        }
        dp[index] = Math.max(nums[index] + dfs(nums, index + 2), dfs(nums, index + 1));
        return dp[index];
    }

    //bottom up approach o(n) time complexity only
    public int robs(int[] nums) {
        int prev1 = 0; // dp[i+1]
        int prev2 = 0; // dp[i+2]

        for (int i = nums.length - 1; i >= 0; i--) {
            int curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}

