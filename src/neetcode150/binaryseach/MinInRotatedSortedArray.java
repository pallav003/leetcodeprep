package neetcode150.binaryseach;

/**
 * Find Minimum in Rotated Sorted Array
 * You are given an array of length n which was originally sorted in ascending order. It has now been rotated between 1 and n times. For example, the array nums = [1,2,3,4,5,6] might become:
 * <p>
 * [3,4,5,6,1,2] if it was rotated 4 times.
 * [1,2,3,4,5,6] if it was rotated 6 times.
 * Notice that rotating the array 4 times moves the last four elements of the array to the beginning. Rotating the array 6 times produces the original array.
 * <p>
 * Assuming all elements in the rotated sorted array nums are unique, return the minimum element of this array.
 * <p>
 * A solution that runs in O(n) time is trivial, can you write an algorithm that runs in O(log n) time?
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,4,5,6,1,2]
 * <p>
 * Output: 1
 */
public class MinInRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        MinInRotatedSortedArray minInRotatedSortedArray = new MinInRotatedSortedArray();
        System.out.println(minInRotatedSortedArray.findMin(new int[]{3, 4, 5, 6, 1, 2}));
    }
}
