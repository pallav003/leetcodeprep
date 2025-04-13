package dp;

/**
 * Problem statement
 * You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.
 * <p>
 * Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.
 * <p>
 * For Example :
 * If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4. These are {1,3} and {4}. Hence, return true.
 * Detailed explanation ( Input/output format, Notes, Images )
 * Constraints:
 * 1 <= T <= 5
 * 1 <= N <= 10^3
 * 0 <= ARR[i] <= 10^9
 * 0 <= K <= 10^3
 * <p>
 * Time Limit: 1 sec
 * Sample Input 1:
 * 2
 * 4 5
 * 4 3 2 1
 * 5 4
 * 2 5 1 6 7
 * Sample Output 1:
 * true
 * false
 * Explanation For Sample Input 1:
 * In example 1, ‘ARR’ is {4,3,2,1} and ‘K’ = 5. There exist 2 subsets with sum = 5. These are {4,1} and {3,2}. Hence, return true.
 * In example 2, ‘ARR’ is {2,5,1,6,7} and ‘K’ = 4. There are no subsets with sum = 4. Hence, return false.
 * Sample Input 2:
 * 2
 * 4 4
 * 6 1 2 1
 * 5 6
 * 1 7 2 9 10
 * Sample Output 2:
 * true
 * false
 * Explanation For Sample Input 2:
 * In example 1, ‘ARR’ is {6,1,2,1} and ‘K’ = 4. There exist 1 subset with sum = 4. That is {1,2,1}. Hence, return true.
 * In example 2, ‘ARR’ is {1,7,2,9,10} and ‘K’ = 6. There are no subsets with sum = 6. Hence, return false.
 */
public class SubSetSumEqualK {

    //Recursive code

    public boolean isSubsetSum(int[] arr, int target) {
        if (arr == null || arr.length == 0) return target == 0;
        // Initialize memoization table with null (uncomputed states)
        Boolean[][] memo = new Boolean[arr.length][target + 1];
        return subsetHelper(arr.length - 1, arr, target, memo);
    }

    private boolean subsetHelper(int currIndex, int[] arr, int target, Boolean[][] memo) {
        if (target == 0) return true;
        if (target < 0 || currIndex < 0) return false;

        if (memo[currIndex][target] != null) return memo[currIndex][target];

        boolean pick = subsetHelper(currIndex - 1, arr, target - arr[currIndex], memo);
        boolean notPick = subsetHelper(currIndex - 1, arr, target, memo);

        memo[currIndex][target] = pick || notPick;
        return memo[currIndex][target];
    }

    public static boolean subsetSumToK(int n, int k, int arr[]) {

        boolean[][] dp = new boolean[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true; // Empty subset sums to 0
        }

        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= k; sum++) {
                if (arr[i-1] <= sum) {
                    dp[i][sum] = dp[i - 1][sum] ||
                            dp[i-1][sum - arr[i - 1]];
                } else {
                    dp[i][sum] = dp[i - 1][sum];
                }
            }
        }
        return dp[n][k];
    }



    public static void main(String[] args) {
        System.out.println(subsetSumToK(5, 6, new int[]{1, 7, 2, 9, 10}));
    }
}

