package dp;

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

}
