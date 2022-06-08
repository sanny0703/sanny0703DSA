package MatrixChainMultiplication.problems.EggDropping;

import java.util.Arrays;

public class Memoization {
    private static int[][] dp;

    public static int minAttempts(int eggs, int floors) {
        dp = new int[eggs + 1][floors + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return solve(eggs, floors);
    }

    public static int solve(int e, int f) {
        if (f == 0 || f == 1) return dp[e][f] = f;
        if (e == 1) return dp[e][f] = f;
        int ans = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int temp = 1 + Math.max(solve(e - 1, k - 1), solve(e, f - k));
            ans = Math.min(ans, temp);
        }
        return dp[e][f] = ans;
    }

    public static void main(String[] args) {
        //3
        System.out.println(minAttempts(2, 4));
    }
}
