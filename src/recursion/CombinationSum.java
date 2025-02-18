package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> outputList = new ArrayList<>();
        combinationSumHelper(outputList, candidates, target, 0, new ArrayList<>());
        return outputList;
    }

    private void combinationSumHelper(List<List<Integer>> outputList,
                                      int[] candidates, int remain, int index,
                                      List<Integer> tempList) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            outputList.add(new ArrayList<>(tempList));
        } else {
            for (int i = index; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                combinationSumHelper(outputList, candidates, remain - candidates[i], i, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(nums, target));
    }
}
