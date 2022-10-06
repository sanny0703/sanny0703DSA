package DynamicProgramming;

import java.util.Arrays;

/**
 * You have n dice and each die has k faces numbered from 1 to k.
 * <br>
 * Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the
 * dice so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo <code>109 + 7</code>.
 * <br>
 * <code>
 * Input: n = 1, k = 6, target = 3
 * Output: 1
 * Explanation: You throw one die with 6 faces.
 * There is only one way to get a sum of 3.
 * <br>
 * Input: n = 2, k = 6, target = 7
 * Output: 6
 * Explanation: You throw two dice, each with 6 faces.
 * There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
 * </code>
 */
public class DiceRolls {
    private static final int MOD = (int) (1e9 + 7);

    public static int memoization(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return recurse(dp, n, k, target);

    }

    private static int recurse(int[][] dp, int n, int k, int target) {
        if (dp[n][target] != -1)
            return dp[n][target];
        if (n == 0 && target == 0)
            return dp[n][target] = 1;
        if (n == 0 || target == 0)
            return dp[n][target] = 0;
        dp[n][target] = 0;
        for (int i = 1; i <= k; i++) {
            if (target - i >= 0) {
                dp[n][target] = (dp[n][target] + recurse(dp, n - 1, k, target - i)) % MOD;
            } else break;
        }
        return dp[n][target];
    }

    public static int bruteForce(int n, int k, int target) {
        if (n == 0) {
            if (target == 0)
                return 1;
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= k; i++) {
            if (target - i >= 0)
                count = (count + bruteForce(n - 1, k, target - i)) % MOD;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(bruteForce(1, 6, 3));
        System.out.println(bruteForce(2, 6, 7));
        System.out.println(memoization(1, 6, 3));
        System.out.println(memoization(2, 6, 7));
        System.out.println(memoization(30, 30, 500));
    }
}
