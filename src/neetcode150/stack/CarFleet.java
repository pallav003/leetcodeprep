package neetcode150.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Car Fleet
 * Solved
 * There are n cars traveling to the same destination on a one-lane highway.
 *
 * You are given two arrays of integers position and speed, both of length n.
 *
 * position[i] is the position of the ith car (in miles)
 * speed[i] is the speed of the ith car (in miles per hour)
 * The destination is at position target miles.
 *
 * A car can not pass another car ahead of it. It can only catch up to another car and then drive at the same speed as the car ahead of it.
 *
 * A car fleet is a non-empty set of cars driving at the same position and same speed. A single car is also considered a car fleet.
 *
 * If a car catches up to a car fleet the moment the fleet reaches the destination, then the car is considered to be part of the fleet.
 *
 * Return the number of different car fleets that will arrive at the destination.
 *
 * Example 1:
 *
 * Input: target = 10, position = [1,4], speed = [3,2]
 *
 * Output: 1
 * Explanation: The cars starting at 1 (speed 3) and 4 (speed 2) become a fleet, meeting each other at 10, the destination.
 *
 * Example 2:
 *
 * Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]
 *
 * Output: 3
 * Explanation: The cars starting at 4 and 7 become a fleet at position 10. The cars starting at 1 and 0 never catch up to the car ahead of them. Thus, there are 3 car fleets that will arrive at the destination.
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0])); // Sort by position (descending)
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i<n;i++) {
            double time = (target - cars[i][0])/ cars[i][1];
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }
        return stack.size();

    }
}
