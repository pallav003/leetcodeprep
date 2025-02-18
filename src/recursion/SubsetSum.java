package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem :
 * Input: N = 3, arr[] = {5,2,1}
 * Output: 0,1,2,3,5,6,7,8
 * <p>
 * Explanation: We have to find all the subset’s sum and print them.
 * in this case the generated subsets are
 * [ [], [1], [2], [2,1], [5], [5,1], [5,2]. [5,2,1],so the sums we get will
 * be  0,1,2,3,5,6,7,8
 **/
public class SubsetSum {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 2, 1);
        List<Integer> subsetsSumlist = new ArrayList<>();
        subsetSum(nums, 0, 0, subsetsSumlist, nums.size());
        System.out.println(subsetsSumlist);
    }

    private static void subsetSum(List<Integer> nums, int start, int sum, List<Integer> subsetsSumlist, int size) {
        if (size == start) {
            subsetsSumlist.add(sum);
            return;
        }
        subsetSum(nums, start + 1, sum + nums.get(start), subsetsSumlist, size);
        subsetSum(nums, start + 1, sum, subsetsSumlist, size);
    }
}
