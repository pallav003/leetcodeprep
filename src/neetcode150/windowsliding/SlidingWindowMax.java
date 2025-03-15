package neetcode150.windowsliding;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Sliding Window Maximum
 * Solved
 * You are given an array of integers nums and an integer k. There is a sliding window of size k that starts at the left edge of the array. The window slides one position to the right until it reaches the right edge of the array.
 *
 * Return a list that contains the maximum element in the window at each step.
 *
 * Example 1:
 *
 * Input: nums = [1,2,1,0,4,2,6], k = 3
 *
 * Output: [2,2,4,4,6]
 *
 * Explanation:
 * Window position            Max
 * ---------------           -----
 * [1  2  1] 0  4  2  6        2
 *  1 [2  1  0] 4  2  6        2
 *  1  2 [1  0  4] 2  6        4
 *  1  2  1 [0  4  2] 6        4
 *  1  2  1  0 [4  2  6]       6
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * 1 <= k <= nums.length
 */
public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int [] outputArr = new int [nums.length - k +1];

        for(int i =0;i<nums.length;i++) {
            // Remove elements that are out of this window
            if (!deque.isEmpty() && deque.peekFirst() < i - k +1) {
                deque.pollFirst();
            }
            // Remove elements from the back that are smaller than the current element
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // Add the current element index
            deque.addLast(i);
            // Store the maximum when the first window is formed
            if(i >= k-1) {
                outputArr[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return outputArr;
    }
}
