package twopointers;

/**
 * Container With Most Water
 * Solved
 * You are given an integer array heights where heights[i] represents the height of the
 * i
 * t
 * h
 * i
 * th
 *   bar.
 *
 * You may choose any two bars to form a container. Return the maximum amount of water a container can store.
 *
 * Example 1:
 *
 *
 *
 * Input: height = [1,7,2,5,4,7,3,6]
 *
 * Output: 36
 */
public class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int maxWater = 0;
        while (i < j) {
            maxWater = Math.max((j - i) * Math.min(heights[i], heights[j]), maxWater);
            if (heights[i] >= heights[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxWater;
    }
}
