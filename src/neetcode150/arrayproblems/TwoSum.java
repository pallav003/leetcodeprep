package neetcode150.arrayproblems;

import java.util.HashMap;
import java.util.Map;


/**
 * Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
 *
 * You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
 *
 * Return the answer with the smaller index first.
 *
 * Example 1:
 *
 * Input:
 * nums = [3,4,5,6], target = 7
 *
 * Output: [
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> indexMap = new HashMap<>();
        for (int i =0; i< nums.length;i++) {
            if (indexMap.containsKey(target - nums[i])) {
                return new int []{indexMap.get(target- nums[i]),i};
            }
            indexMap.put(nums[i],i);
        }
        return new int []{0,0};
    }
}
