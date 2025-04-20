package dp;

/**
 * Given n items, each with a specific weight and value, and a knapsack with a capacity of W, the task is to put the items in the knapsack such that the sum of weights of the items <= W and the sum of values associated with them is maximized.
 * <p>
 * Note: You can either place an item entirely in the bag or leave it out entirely. Also, each item is available in single quantity.
 * <p>
 * Examples :
 * <p>
 * Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]
 * Output: 3
 * Explanation: Choose the last item, which weighs 1 unit and has a value of 3.
 * Input: W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6]
 * Output: 0
 * Explanation: Every item has a weight exceeding the knapsack's capacity (3).
 * Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3]
 * Output: 80
 * Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.
 */
public class Knapsack {
    static int[][] dp;

    static int knapsack(int W, int val[], int wt[]) {
        // code here
        dp = new int[val.length + 1][W + 1];
        for (int i = 0; i < val.length + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return knapsack(W, val, wt, val.length);
    }

    static int knapsack(int W, int val[], int wt[],
                        int currentIndex) {
        if (W == 0 || currentIndex == 0) return 0;

        if (dp[currentIndex][W] != -1) return dp[currentIndex][W];
        if (wt[currentIndex - 1] <= W) {
            dp[currentIndex][W] =
                    Math.max(
                            val[currentIndex - 1] + knapsack(W - wt[currentIndex - 1], val, wt, currentIndex - 1),
                            knapsack(W, val, wt, currentIndex - 1)
                    );
        } else {
            dp[currentIndex][W] = knapsack(W, val, wt, currentIndex - 1);
        }
        return dp[currentIndex][W];
    }

}
