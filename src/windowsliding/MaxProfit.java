package windowsliding;

/**
 * Best Time to Buy and Sell Stock
 * Solved
 * You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.
 * <p>
 * You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.
 * <p>
 * Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [10,1,5,6,7,1]
 * <p>
 * Output: 6
 * Explanation: Buy prices[1] and sell prices[4], profit = 7 - 1 = 6.
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int temp = prices[0];
        int output = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - temp > 0) {
                output = Math.max(output, prices[i] - temp);
            } else {
                temp = prices[i];
            }
        }
        return output;

    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 5, 6, 7, 1};
        MaxProfit maxProfit = new MaxProfit();
        System.out.print(maxProfit.maxProfit(arr));
    }
}
