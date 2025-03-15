package neetcode150.arrayproblems;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [1, 2, 3, 3]
 *
 * Output: true
 */
public class DuplicateElement {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}