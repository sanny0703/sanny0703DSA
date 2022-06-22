package DynamicProgramming.CombinationSum;

import java.util.Arrays;

/**
 * Given an array of distinct integers nums and a target integer target,
 * return the number of possible combinations that add up to target.
 * <br>
 * <br>
 * <code>
 * Input: nums = [1,2,3], target = 4
 * <br>
 * Output: 7
 * <br>
 * Explanation:
 * <br>
 * The possible combination ways are:
 * <br>
 * (1, 1, 1, 1)
 * <br>
 * (1, 1, 2)
 * <br>
 * (1, 2, 1)
 * <br>
 * (1, 3)
 * <br>
 * (2, 1, 1)
 * <br>
 * (2, 2)
 * <br>
 * (3, 1)
 * <br>
 * Note that different sequences are counted as different combinations.
 * </code>
 */
public class Four {
    public static int combinations(int[] arr, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return helper(0, arr, dp, target);
    }

    public static int helper(int val, int[] arr, int[] dp, int target) {
        if (target == val) return 1;
        if (dp[val] != -1)
            return dp[val];
        int ans = 0;
        for (int j : arr) {
            if (j + val <= target) {
                ans += helper(val + j, arr, dp, target);
            }
        }
        return dp[val] = ans;
    }

    public static void main(String[] args) {
        System.out.println(combinations(new int[]{1, 2, 3}, 4));
    }
}
