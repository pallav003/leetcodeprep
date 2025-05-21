package dp;

import java.util.Arrays;

/**
 * 322. Coin Change
 * Solved
 * Medium
 * Topics
 * Companies
 * You are given an integer array coins representing coins of
 * different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 * <p>
 * Input: coins = [1], amount = 0
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinChange {

    //Recursive with memoization
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int output = coinChangeHelper(coins, amount, dp);
        return output == Integer.MAX_VALUE ? -1 : output;

    }

    private int coinChangeHelper(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != Integer.MAX_VALUE) {
            return dp[amount];
        }
        int minCoinCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangeHelper(coins, amount - coin, dp);
            if (res != Integer.MAX_VALUE) {
                minCoinCount = Math.min(minCoinCount, res + 1);
            }
        }
        dp[amount] = minCoinCount;
        return dp[amount];
    }


    //bottom up memoization
    public int coinChanges(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int amt = 1; amt <= amount; amt++) {
            for (int coin : coins) {
                if (amt - coin >= 0)
                    dp[amt] = Math.min(dp[amt], dp[amt - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
