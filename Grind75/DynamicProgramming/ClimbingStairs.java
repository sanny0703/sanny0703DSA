package DynamicProgramming;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <br>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <br>
 * <br>
 * <code>
 * Input: n = 2
 * <br>
 * Output: 2
 * <br>
 * Explanation: There are two ways to climb to the top.
 * <br>
 * 1. 1 step + 1 step
 * <br>
 * 2. 2 steps
 * </code>
 */
public class ClimbingStairs {
    public static int countWays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countWays(2));
    }
}
