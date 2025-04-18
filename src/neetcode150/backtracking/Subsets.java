package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subsets
 * Solved
 * Given an array nums of unique integers, return all possible subsets of nums.
 * <p>
 * The solution set must not contain duplicate subsets. You may return the solution in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * <p>
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 * <p>
 * Input: nums = [7]
 * <p>
 * Output: [[],[7]]
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        subsets(nums, new ArrayList<>(), 0, output);
        return output;

    }

    public void subsets(int[] nums,
                        List<Integer> tempList, int index,
                        List<List<Integer>> outputList) {
        outputList.add(new ArrayList<>(tempList));
        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            subsets(nums, tempList, i + 1, outputList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
