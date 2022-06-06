package MatrixChainMultiplication.problems.PalindromePartitioning;

import java.util.Arrays;

public class memoization {
    private static int[][] dp;

    public static int minPartitions(String s) {
        int n = s.length();
        dp = new int[n + 1][n + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        int i = 0, j = n - 1;
        return solve(s, i, j);
    }

    public static int solve(String s, int i, int j) {
        if (i >= j) return 0; // partitions when i==j or i>j
        if (dp[i][j] != -1) return dp[i][j];
        if (isPalindrome(s, i, j)) return 0; // no further partitioning required when s itself is a palindrome
        int temp = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            temp = Math.min(temp, solve(s, i, k) + solve(s, k + 1, j) + 1);
        }
        return dp[i][j] = temp;

    }

    public static boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long a = System.nanoTime();
        // 3{"n|it|im"}
        System.out.println(minPartitions("nitim"));
        // 3{“aba|b|bbabb|ababa” }
        System.out.println(minPartitions("ababbbabbababa"));
        System.out.println("Time: " + (System.nanoTime() - a) / 10000);
    }
}
