package arrayproblems;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Longest Consecutive Sequence
 * Given an array of integers nums, return the length of the longest consecutive sequence of elements that can be formed.
 * <p>
 * A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element. The elements do not have to be consecutive in the original array.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,20,4,10,3,4,5]
 * <p>
 * Output: 4
 * Explanation: The longest consecutive sequence is [2, 3, 4, 5].
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,3,2,5,4,6,1,1]
 * <p>
 * Output: 7
 */
public class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int maxLength = 1;
        for (int i : nums) {
            if (!set.contains(i+1)) {
                int tempLength = 1;
                while (set.contains(i-1)) {
                    tempLength++;
                    i--;
                }
                maxLength = Math.max(tempLength, maxLength);
            }
        }
        return maxLength;
    }
}
