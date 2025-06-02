package cses;

/**
 * There are several cards arranged in a row, and each card has
 * an associated number of points. The points are given in the integer array cardPoints.
 * <p>
 * In one step, you can take one card from the beginning or from
 * the end of the row. You have to take exactly k cards.
 * <p>
 * Your score is the sum of the points of the cards you have taken.
 * <p>
 * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: cardPoints = [1,2,3,4,5,6,1], k = 3
 * Output: 12
 * Explanation: After the first step, your score will always be 1. However,
 * choosing the rightmost card first will maximize your total score
 * . The optimal strategy is to take the three cards on the right,
 * giving a final score of 1 + 6 + 5 = 12.
 * Example 2:
 * <p>
 * Input: cardPoints = [2,2,2], k = 2
 * Output: 4
 * Explanation: Regardless of which two cards you take, your score will always be 4.
 * Example 3:
 * <p>
 * Input: cardPoints = [9,7,7,9,7,7,9], k = 7
 * Output: 55
 * Explanation: You have to take all the cards. Your score is the sum of points of all cards.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= cardPoints.length <= 105
 * 1 <= cardPoints[i] <= 104
 * 1 <= k <= cardPoints.length
 */
public class MaxPoints {
    public int maxScore(int[] cardPoints, int k) {
        int leftsum = 0;
        for (int i = 0; i < k; i++)
            leftsum += cardPoints[i];
        int rightsum = 0;
        int output = leftsum;
        int rightIndex = cardPoints.length - 1;
        for (int leftIndex = k - 1; leftIndex >= 0; leftIndex--) {
            rightsum += cardPoints[rightIndex];
            leftsum -= cardPoints[leftIndex];
            rightIndex--;
            output = Math.max(leftsum + rightsum, output);
        }
        return output;
    }
}
