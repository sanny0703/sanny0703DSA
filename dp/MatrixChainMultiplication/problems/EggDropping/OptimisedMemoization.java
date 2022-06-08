package MatrixChainMultiplication.problems.EggDropping;

import java.util.Arrays;

/**
 * the ides here is to use binary search instead of linearly trying out for each k
 */
public class OptimisedMemoization {
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
        int low = 1, high = f;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int a = solve(e - 1, mid - 1);
            int b = solve(e, f - mid);
            int temp = 1 + Math.max(a, b);
            ans = Math.min(ans, temp);
            if (a > b) high = mid - 1;
            else low = mid + 1;
        }
        return dp[e][f] = ans;
    }

    public static void main(String[] args) {
        //3
        System.out.println(minAttempts(2, 4));
    }
}
