package array;

/**
 * Given an integer array nums, find a subarray that has the largest product,
 * and return the product.
 * <p>
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
 */
public class MaxProductSubArray {

    public int maxProduct(int[] nums) {
        int output = nums[0];
        int maxout = nums[0];
        int minout = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currMax = maxout;
            int currMin = minout;
            maxout = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
            minout = Math.min(nums[i], Math.min(currMax * nums[i], currMin * nums[i]));

            output = Math.max(maxout, output);
        }
        return output;
    }
}
