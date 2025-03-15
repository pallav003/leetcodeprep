package neetcode150.twopointers;

/**
 * Two Integer Sum II
 * Given an array of integers numbers that is sorted in non-decreasing order.
 * <p>
 * Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.
 * <p>
 * There will always be exactly one valid solution.
 * <p>
 * Your solution must use
 * O
 * (
 * 1
 * )
 * O(1) additional space.
 * <p>
 * Example 1:
 * <p>
 * Input: numbers = [1,2,3,4], target = 3
 * <p>
 * Output: [1,2]
 * Explanation:
 * The sum of 1 and 2 is 3. Since we are assuming a 1-indexed array, index1 = 1, index2 = 2. We return [1, 2].
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{0, 0};

    }
}
