package neetcode150.stack;

import java.util.Stack;

/**
 * Largest Rectangle In Histogram
 * You are given an array of integers heights where heights[i] represents the height of a bar. The width of each bar is 1.
 * <p>
 * Return the area of the largest rectangle that can be formed among the bars.
 * <p>
 * Note: This chart is known as a histogram.
 * <p>
 * Example 1:
 * <p>
 * Input: heights = [7,1,7,2,2,4]
 * <p>
 * Output: 8
 * Example 2:
 * <p>
 * Input: heights = [1,3,7]
 * <p>
 * Output: 7
 * Constraints:
 * <p>
 * 1 <= heights.length <= 1000.
 * 0 <= heights[i] <= 1000
 */

public class LargestRectangleHistogram {

    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        // Finding NSL (Next Smaller to the Left)
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek(); // -1 kept for beginning
            stack.push(i);
        }
        stack.clear();
        //Finding NSR( Next smaller to the right
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? heights.length : stack.peek(); // heights.length for ending
            stack.push(i);
        }
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleHistogram largestRectangleHistogram = new LargestRectangleHistogram();
        System.out.println(largestRectangleHistogram.largestRectangleArea(new int[]{7, 1, 7, 2, 2, 4}));
    }
}
