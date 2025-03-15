package neetcode150.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    output.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }

                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return output;

    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.print(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
