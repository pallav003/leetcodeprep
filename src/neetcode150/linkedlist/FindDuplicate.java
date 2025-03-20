package neetcode150.linkedlist;

/**
 * Find the Duplicate Number
 * You are given an array of integers nums containing n + 1 integers. Each integer in nums is in the range [1, n] inclusive.
 * <p>
 * Every integer appears exactly once, except for one integer which appears two or more times. Return the integer that appears more than once.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,2,2]
 * <p>
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4,4]
 * <p>
 * Output: 4
 * Follow-up: Can you solve the problem without modifying the array nums and using
 * O
 * (
 * 1
 * )
 * O(1) extra space?
 */
public class FindDuplicate {

    //Solution via modification
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                return Math.abs(nums[i]);
            } else {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        return -1;

    }

    // Solution via linkedlist cycle detection
    public int findDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;

    }

    public static void main(String[] args) {
        FindDuplicate findDuplicate = new FindDuplicate();
        System.out.println(findDuplicate.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
