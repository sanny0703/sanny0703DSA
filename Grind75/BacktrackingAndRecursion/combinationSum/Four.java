package BacktrackingAndRecursion.combinationSum;

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
        // for 0 target there is only one combination {}
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : arr) {
                if (i - num >= 0)
                    dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        System.out.println(combinations(new int[]{1, 2, 3}, 4));
    }
}
