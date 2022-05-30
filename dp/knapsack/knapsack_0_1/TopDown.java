package knapsack.knapsack_0_1;

import java.util.Arrays;

public class TopDown {

    public static int knapsack(int[] weights, int[] values, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];
        for (int[] a : dp) Arrays.fill(a, -1);
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] val = new int[]{60, 100, 120};
        int[] wt = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapsack(wt, val, n, W));
    }
}
