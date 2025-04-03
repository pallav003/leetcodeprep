package dp;

import java.util.Arrays;

/**
 * 0 1 Knapsack
 * Problem statement
 * A thief is robbing a store and can carry a maximal weight of W into his knapsack.
 * There are N items and the ith item weighs wi and is of value vi.
 * Considering the constraints of the maximum weight that a knapsack can carry,
 * you have to find and return the maximum value that a thief can generate by stealing items.
 */
public class KnapSackProblem {

    //complexity 2^n since while including and excluding the
    // value we are not recalculating overlapping weights
    static int knapsack(int[] weight, int[] value,
                        int n, int maxWeight) {
        if (maxWeight == 0 || n == 0) {
            return 0;
        }
        if (weight[n - 1] <= maxWeight) {
            return Math.max(
                    value[n - 1] + knapsack(weight, value, n - 1, maxWeight - weight[n - 1]),
                    knapsack(weight, value, n - 1, maxWeight));
        } else {
            return knapsack(weight, value, n - 1, maxWeight);
        }
    }

    //recursive with memoization

    public static int [][] dp;
    static int knapsackSolution(int[] weight, int[] value,
                        int n, int maxWeight) {
        dp = new int[n+1][maxWeight+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return knapsacks(weight,value,n,maxWeight);
    }

    static int knapsacks(int[] weight, int[] value,
                         int n ,int maxWeight) {
        if (maxWeight == 0 || n == 0) {
            return 0;
        }
        if(dp[n][maxWeight] != -1) {
            return dp[n][maxWeight];
        }

        if (weight[n - 1] <= maxWeight) {
            dp[n][maxWeight] = Math.max(
                    value[n - 1] + knapsacks(weight, value, n - 1, maxWeight - weight[n - 1]),
                    knapsacks(weight, value, n - 1, maxWeight));
        } else {
            dp[n][maxWeight]= knapsacks(weight, value, n - 1, maxWeight);
        }
        return dp[n][maxWeight];
    }
}
