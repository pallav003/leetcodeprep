package neetcode150.dynamicprogramming.OneD;

/**
 * Min Cost Climbing Stairs
 * Solved
 * You are given an array of integers cost where cost[i] is the cost of taking a step from the ith floor of a staircase. After paying the cost, you can step to either the (i + 1)th floor or the (i + 2)th floor.
 * <p>
 * You may choose to start at the index 0 or the index 1 floor.
 * <p>
 * Return the minimum cost to reach the top of the staircase, i.e. just past the last index in cost.
 * <p>
 * Example 1:
 * <p>
 * Input: cost = [1,2,3]
 * <p>
 * Output: 2
 * Explanation: We can start at index = 1 and pay the cost of cost[1] = 2 and take two steps to reach the top. The total cost is 2.
 * <p>
 * Example 2:
 * <p>
 * Input: cost = [1,2,1,2,1,1,1]
 * <p>
 * Output: 4
 * Explanation: Start at index = 0.
 * <p>
 * Pay the cost of cost[0] = 1 and take two steps to reach index = 2.
 * Pay the cost of cost[2] = 1 and take two steps to reach index = 4.
 * Pay the cost of cost[4] = 1 and take two steps to reach index = 6.
 * Pay the cost of cost[6] = 1 and take one step to reach the top.
 * The total cost is 4.
 * Constraints:
 * <p>
 * 2 <= cost.length <= 100
 * 0 <= cost[i] <= 100
 */
public class MinCostClimbingStairs {
    int[] cache;

    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length];
        return Math.min(DFS(0, cost), DFS(1, cost));
    }

    public int DFS(int i, int[] cost) {
        if (i >= cost.length) return 0;
        if (cache[i] != 0) return cache[i];
        cache[i] = cost[i] + Math.min(DFS(i + 1, cost), DFS(i + 2, cost));
        return cache[i];
    }
}
