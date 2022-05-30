package knapsack.knapsack_0_1;

import java.util.Arrays;

public class Memoization {
    static int[][] dp;

    public static int knapsack(int[] weights, int[] values, int n, int W) {
        if (n == 0 || W == 0) return dp[n][W] = 0;
        if (dp[n][W] != -1) return dp[n][W];
        else if (weights[n - 1] <= W)
            return dp[n][W] = Math.max(values[n - 1] + knapsack(weights, values, n - 1, W - weights[n - 1]), knapsack(weights, values, n - 1, W));
        else return knapsack(weights, values, n - 1, W);

    }

    public static void main(String[] args) {
        int[] val = new int[]{60, 100, 120};
        int[] wt = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        dp = new int[n + 1][W + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(knapsack(wt, val, n, W));
    }
}
