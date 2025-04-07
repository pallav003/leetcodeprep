package dp;

import java.util.Arrays;

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
