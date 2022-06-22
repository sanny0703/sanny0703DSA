package DynamicProgramming.LIS;

import java.util.Arrays;

public class Memoization {
    static int[][] dp;

    public static int LIS(int[] arr) {
        int n = arr.length;
        if (n == 1) return 1;
        dp = new int[n][n];
        for (int[] a : dp) Arrays.fill(a, -1);
        return helper(arr, 0, -1);

    }

    public static int helper(int[] arr, int cur, int prev) {
        if (cur == arr.length) return 0;
        if (prev != -1 && dp[cur][prev] != -1) return dp[cur][prev];
        int include = Integer.MIN_VALUE;
        if (prev == -1 || arr[prev] < arr[cur]) include = 1 + helper(arr, cur + 1, cur);
        int ignore = helper(arr, cur + 1, prev);
        if (prev != -1) return dp[cur][prev] = Math.max(ignore, include);
        return Math.max(include, ignore);
    }

    public static void main(String[] args) {
        System.out.println(LIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(LIS(new int[]{0, 1, 0, 3, 2, 3}));
    }
}
