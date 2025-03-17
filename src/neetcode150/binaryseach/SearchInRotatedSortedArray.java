package neetcode150.binaryseach;

/**
 * Search in Rotated Sorted Array
 * You are given an array of length n which was originally sorted in ascending order. It has now been rotated between 1 and n times. For example, the array nums = [1,2,3,4,5,6] might become:
 * <p>
 * [3,4,5,6,1,2] if it was rotated 4 times.
 * [1,2,3,4,5,6] if it was rotated 6 times.
 * Given the rotated sorted array nums and an integer target, return the index of target within nums, or -1 if it is not present.
 * <p>
 * You may assume all elements in the sorted rotated array nums are unique,
 * <p>
 * A solution that runs in O(n) time is trivial, can you write an algorithm that runs in O(log n) time?
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,4,5,6,1,2], target = 1
 * <p>
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [3,5,6,0,1,2], target = 4
 * <p>
 * Output: -1
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // Determine if left half is sorted
            if (nums[left] <= nums[mid]) {
                // Target lies in the left half
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;  // Move left
                } else {
                    left = mid + 1;   // Move right
                }
            }
            // Right half is sorted
            else {
                // Target lies in the right half
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;   // Move right
                } else {
                    right = mid - 1;  // Move left
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        System.out.println(search.search(new int[]{3, 4, 5, 6, 1, 2}, 1));
        System.out.println(search.search(new int[]{3, 5, 6, 0, 1, 2}, 4));

    }

}
