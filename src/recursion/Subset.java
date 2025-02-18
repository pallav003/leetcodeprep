package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem :
 * Input: N = 3, arr[] = {5,2,1}
 * Output: 0,1,2,3,5,6,7,8
 * <p>
 * Explanation: We have to find all the subset’s sum and print them.
 * in this case the generated subsets are
 * [ [], [1], [2], [2,1], [5], [5,1], [5,2]. [5,2,1]
 **/

public class Subset {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetList = new ArrayList<>();
        backtrack(0, nums, subsetList, new ArrayList<>());
        return subsetList;
    }

    private static void backtrack(int start, int[] nums, List<List<Integer>> subsetList,
                                  ArrayList<Integer> tempList) {
        subsetList.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(i+1, nums, subsetList, tempList);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 1};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }
}
