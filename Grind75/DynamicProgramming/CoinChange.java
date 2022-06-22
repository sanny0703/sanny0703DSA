package DynamicProgramming;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <br>
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <br>
 * You may assume that you have an infinite number of each kind of coin.
 * <br>
 * <br>
 * <code>
 * Input: coins = [1,2,5], amount = 11
 * <br>
 * Output: 3
 * <br>
 * Explanation: 11 = 5 + 5 + 1
 * </code>
 */
public class CoinChange {
    public static int minCoins(int[] coins, int target) {
        int n = coins.length;
        int[][] dp = new int[n + 1][target + 1];
        for (int j = 1; j < target + 1; j++) dp[0][j] = Integer.MAX_VALUE - 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (coins[i - 1] <= j) dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        System.out.println(minCoins(new int[]{1, 2, 5}, 11));
    }
}
