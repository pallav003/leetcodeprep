package neetcode150.stack;

import java.util.Stack;

/**
 * Daily Temperatures
 * You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith day.
 * <p>
 * Return an array result where result[i] is the number of days after the ith day before
 * a warmer temperature appears on a future day.
 * If there is no day in the future where a warmer temperature will appear for the ith day,
 * set result[i] to 0 instead.
 * <p>
 * Example 1:
 * <p>
 * Input: temperatures = [30,38,30,36,35,40,28]
 * <p>
 * Output: [1,4,1,2,1,0,0]
 * Example 2:
 * <p>
 * Input: temperatures = [22,21,20]
 * <p>
 * Output: [0,0,0]
 * Constraints:
 * <p>
 * 1 <= temperatures.length <= 1000.
 * 1 <= temperatures[i] <= 100
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int result [] = new int[temperatures.length];
        for(int i = 0; i< temperatures.length;i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int [] output = dailyTemperatures.dailyTemperatures(new int[]{30, 38, 30, 36, 35, 40, 28});
        for (int i : output) {
            System.out.print(i + " ");
        }
    }
}
