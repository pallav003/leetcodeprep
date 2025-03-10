package arrayproblems;

/**
 * Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].
 * <p>
 * Each product is guaranteed to fit in a 32-bit integer.
 * <p>
 * Follow-up: Could you solve it in
 * O
 * (
 * n
 * )
 * O(n) time without using the division operation?
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,4,6]
 * <p>
 * Output: [48,24,12,8]
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] prefArr = new int[nums.length];
        int[] suffArr = new int[nums.length];
        prefArr[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefArr[i] = prefArr[i - 1] * nums[i - 1];
        }
        suffArr[nums.length-1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffArr[i] = suffArr[i + 1] * nums[i + 1];
        }
        int[] outputArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            outputArr[i] = prefArr[i] * suffArr[i];
        }
        return outputArr;
    }
}
