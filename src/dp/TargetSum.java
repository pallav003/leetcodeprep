package dp;

import java.util.Arrays;

/**
 * Target Sum
 * Solved
 * You are given an array of integers nums and an integer target.
 * <p>
 * For each number in the array, you can choose to either add or subtract it to a total sum.
 * <p>
 * For example, if nums = [1, 2], one possible sum would be "+1-2=-1".
 * If nums=[1,1], there are two different ways to sum the input numbers to get a sum of 0: "+1-1" and "-1+1".
 * <p>
 * Return the number of different ways that you can build the expression such that the total sum equals target.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,2,2], target = 2
 * <p>
 * Output: 3
 * Explanation: There are 3 different ways to sum the input numbers to get a sum of 2.
 * +2 +2 -2 = 2
 * +2 -2 +2 = 2
 * -2 +2 +2 = 2
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * -1000 <= target <= 1000
 */
public class TargetSum {

    int[][] dp;

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) sum += i;
        dp = new int[nums.length][2001];
        for (int[] row : dp) Arrays.fill(row, -1);
        return targetSumHelper(nums, target, 0, 0);
    }

    public int targetSumHelper(int[] nums, int target,
                               int currentSum, int index) {
        if (currentSum == target && index == nums.length) return 1;
        if (index >= nums.length) return 0;
        int sumIndex = currentSum + 1000;
        if (dp[index][sumIndex] != -1) return dp[index][sumIndex];
        dp[index][sumIndex] =
                targetSumHelper(nums, target, currentSum + nums[index], index + 1) +
                        targetSumHelper(nums, target, currentSum - nums[index], index + 1);
        return dp[index][sumIndex];
    }

}
