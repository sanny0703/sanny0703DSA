package longestCommonSubsequence;

import java.util.Arrays;

public class Memoization {
    private static int[][] dp;

    public static int lcs(String x, String y, int n, int m) {
        if (dp[n][m] != -1) return dp[n][m];
        if (n == 0 || m == 0) return dp[n][m] = 0;
        if (x.charAt(n - 1) == y.charAt(m - 1)) return dp[n][m] = 1 + lcs(x, y, n - 1, m - 1);
        else return dp[n][m] = Math.max(lcs(x, y, n - 1, m), lcs(x, y, n, m - 1));
    }

    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";
        long a = System.nanoTime();
        dp = new int[x.length() + 1][y.length() + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        System.out.println(lcs(x, y, x.length(), y.length()));
        System.out.println((System.nanoTime() - a) / 10000);
    }
}
