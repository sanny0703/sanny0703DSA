package knapsack.unboundedKnapsack;

/***
 * Coin Change Problem Maximum Number of ways<br>
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,<br>
 * how many ways can we make the change? The order of coins does not matter.<br>
 * <i>Example:<br>
 *  for N = 4 and S = {1,2,3}<br>
 *  there are four solutions:<br>
 *  {1,1,1,1},<br>
 *  {1,1,2},<br>
 *  {2,2},<br>
 *  {1,3}<br>
 *  So output should be 4.</i>
 */
public class CoinChange {

    public static int count(int[] coins, int n, int W) {

        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (j == 0) dp[i][j] = 1;
                else if (coins[i - 1] <= j)
                    dp[i][j] = dp[i][j - coins[i - 1]] // if we can use i , we might be using it in the future, so we are not going to drop it
                            + dp[i - 1][j];// since we cannot use it here, we won't be using it further in this call
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int W = 4;
        // 4
        System.out.println(count(coins, 3, W));
    }
}
