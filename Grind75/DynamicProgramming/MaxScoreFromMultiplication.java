package DynamicProgramming;

import java.util.Arrays;

/**
 * You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.
 * <p>
 * You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:
 * <p>
 * Choose one integer x from either the start or the end of the array nums.
 * Add multipliers[i] * x to your score.
 * Remove x from the array nums.
 * Return the maximum score after performing m operations.
 * <p>
 * Input: nums = [1,2,3], multipliers = [3,2,1]
 * Output: 14
 * Explanation: An optimal solution is as follows:
 * - Choose from the end, [1,2,3], adding 3 * 3 = 9 to the score.
 * - Choose from the end, [1,2], adding 2 * 2 = 4 to the score.
 * - Choose from the end, [1], adding 1 * 1 = 1 to the score.
 * The total score is 9 + 4 + 1 = 14.
 */
public class MaxScoreFromMultiplication {
    /**
     * Greedy doesn't work here because consider this example:
     * <p>
     * Input: nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
     * Output: 102
     * Explanation: An optimal solution is as follows:
     * - Choose from the start, [-5,-3,-3,-2,7,1], adding -5 * -10 = 50 to the score.
     * - Choose from the start, [-3,-3,-2,7,1], adding -3 * -5 = 15 to the score.
     * - Choose from the start, [-3,-2,7,1], adding -3 * 3 = -9 to the score.
     * - Choose from the end, [-2,7,1], adding 1 * 4 = 4 to the score.
     * - Choose from the end, [-2,7], adding 7 * 6 = 42 to the score.
     * The total score is 50 + 15 - 9 + 4 + 42 = 102.
     *
     */

    public static int maxScoreBottomUp(int[] nums, int[] muls) {
        int n = nums.length, m = muls.length;
        int[][] memo = new int[m][m];
        for (int[] a : memo) Arrays.fill(a, -1);
        return dp(0, 0, nums, muls, n, m, memo);
    }

    private static int dp(int left, int index, int[] nums, int[] muls, int n, int m, int[][] memo) {
        if (index == m) // we have visited the m elements
            return 0;
        if (memo[left][index] != -1)
            return memo[left][index];
        int leftMul = dp(left + 1, index + 1, nums, muls, n, m, memo) + nums[left] * muls[index];
        // hack: instead of carrying variable for right also, we can just use n-1-(i-left)
        int rightMul = dp(left, index + 1, nums, muls, n, m, memo) // if we consider going with left one
                + nums[n - 1 - (index - left)] * muls[index]; // if we consider going with right one
        return memo[left][index] = Math.max(leftMul, rightMul);
    }

    public static int maxScoreTopDown(int[] nums, int[] muls) {
        int n = nums.length, m = muls.length;
        int[][] dp = new int[m + 1][m + 1];
        // if index == m , we end up with 0, so we can ignore that row
        for (int index = m - 1; index >= 0; index--) {
            for (int left = index; left >= 0; left--) {
                dp[left][index] = Math.max(dp[left + 1][index + 1] + nums[left] * muls[index], dp[left][index + 1] // if we consider left
                        + nums[n - 1 - (index - left)] * muls[index]); // if we consider right
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println("====== Bottom Up======");
        int[] nums = new int[]{1, 2, 3}, muls = new int[]{3, 2, 1};
        int[] nums2 = new int[]{-5, -3, -3, -2, 7, 1}, muls2 = new int[]{-10, -5, 3, 4, 6};
        System.out.println(maxScoreBottomUp(nums, muls));
        System.out.println(maxScoreBottomUp(nums2, muls2));
        System.out.println("===== Top Down ========");
        System.out.println(maxScoreTopDown(nums, muls));
        System.out.println(maxScoreTopDown(nums2, muls2));
    }
}
