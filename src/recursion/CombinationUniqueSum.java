package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationUniqueSum {
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
                if (i > index && candidates[i] == candidates[i-1]) continue;
                if (candidates[i] > remain) {
                    break;
                }
                tempList.add(candidates[i]);
                combinationSumHelper(outputList, candidates, remain - candidates[i], i+1, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        Arrays.sort(nums);
        int target = 8;
        CombinationUniqueSum combinationSum = new CombinationUniqueSum();
        System.out.println(combinationSum.combinationSum(nums, target));
    }
}
