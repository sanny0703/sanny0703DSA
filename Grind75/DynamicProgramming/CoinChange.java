package DynamicProgramming;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <br>
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <br>
 * You may assume that you have an infinite number of each kind of coin.
 * <br>
 * <br>
 * <code>
 * Input: coins = [1,2,5], amount = 11
 * <br>
 * Output: 3
 * <br>
 * Explanation: 11 = 5 + 5 + 1
 * </code>
 */
public class CoinChange {
    public static int minCoins(int[] coins, int target) {

        int[] dp = new int[target + 1];
        int upperBound = target + 1; //upperbound for no fo combinations
        Arrays.fill(dp, upperBound);
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[target] == upperBound ? -1 : dp[target];
    }

    public static void main(String[] args) {
        System.out.println(minCoins(new int[]{1, 2, 5}, 11));
    }
}
