package knapsack.unboundedKnapsack;

public class CoinChangeMinCoins {

    public static int minCoins(int[] coins, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];
        // filling first row
        // we are taking Integer.MAX_VALUE-1 here because 1+Integer.MAX_VALUE becomes Integer.MIN_VALUE and that affects our answer
        for (int j = 1; j < W + 1; j++) dp[0][j] = Integer.MAX_VALUE - 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (coins[i - 1] <= j) dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][W] == Integer.MAX_VALUE - 1 ? -1 : dp[n][W];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int W = 4;
        // 2 -> {1+3}
        System.out.println(minCoins(coins, 3, W));
    }
}
