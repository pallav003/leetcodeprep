package dp;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {
    private Boolean[] dp;

    public boolean canJump(int[] nums) {
        dp = new Boolean[nums.length];
        return canJumps(nums, 0);
    }

    public boolean canJumps(int[] nums, int index) {
        if (index >= nums.length) {
            return false;
        }
        if (index == nums.length - 1) {
            return true;
        }
        if (dp[index] != null) return dp[index];
        for (int i = 1; i <= nums[index]; i++) {
            if (canJumps(nums, index + i)) {
                dp[index] = true;
                return true;
            }
        }

        dp[index] = false;
        return dp[index];
    }
}
