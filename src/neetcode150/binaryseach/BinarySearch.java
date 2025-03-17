package neetcode150.binaryseach;

/**
 * Binary Search
 * Solved
 * You are given an array of distinct integers nums, sorted in ascending order, and an integer target.
 * <p>
 * Implement a function to search for target within nums. If it exists, then return its index, otherwise, return -1.
 * <p>
 * Your solution must run in
 * O
 * (
 * l
 * o
 * g
 * n
 * )
 * O(logn) time.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,2,4,6,8], target = 4
 * <p>
 * Output: 3
 * Example 2:
 * <p>
 * Input: nums = [-1,0,2,4,6,8], target = 3
 * <p>
 * Output: -1
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
