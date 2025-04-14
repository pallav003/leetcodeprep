package dp;

/**
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class EqualSumPartition {
    Boolean[][] dp;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        dp = new Boolean[nums.length][sum + 1];
        return equalSumHelper(0, nums, 0, sum / 2);
    }

    public boolean equalSumHelper(int index, int[] nums, int currentSum, int target) {
        if (index >= nums.length || currentSum > target) return false;
        if (currentSum == target) return true;
        if (dp[index][currentSum] != null) return dp[index][currentSum];
        boolean pick = equalSumHelper(index + 1, nums, currentSum + nums[index],
                target);
        boolean notPick = equalSumHelper(index + 1, nums, currentSum, target);
        dp[index][currentSum] = pick || notPick;
        return dp[index][currentSum];
    }
}
