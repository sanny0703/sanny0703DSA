package knapsack.knapsack_0_1.problems;

import java.util.Arrays;

/**
 * <code>given an arr return no of ways + or - can be placed in front of each element such that sum is equal to given number<br>
 * eg: nums = [1,1,1,1,1], target = 3<br>
 * -1 + 1 + 1 + 1 + 1 = 3<br>
 * +1 - 1 + 1 + 1 + 1 = 3<br>
 * +1 + 1 - 1 + 1 + 1 = 3<br>
 * +1 + 1 + 1 - 1 + 1 = 3<br>
 * +1 + 1 + 1 + 1 - 1 = 3<br>
 */
public class TargetSum {
    /**
     * <code>
     *     -1 + 1 + 1 + 1 + 1 = 3<br>
     *     (1+1+1+1)-(1)<br>
     *     S1-S2 = diff<br>
     *     S1+S2 = sum<br>
     *     S1 = (diff+sum)/2<br>
     *     (diff+sum) cannot be odd here
     * </code>
     *
     */
    public static int count(int[] nums, int n, int diff) {
        int sum = Arrays.stream(nums).sum();
        if (Math.abs(diff) > sum || (sum + diff) % 2 != 0) return 0;
        int target = (sum + diff) / 2;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        // not filling for j=0 because 0 is also being considered
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (nums[i - 1] <= j) dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int diff = 3;
        System.out.println(count(nums, 5, diff));

        int[] nums2 = {0,0,0,0,0,0,0,1};
        System.out.println(count(nums2,8,1));
    }
}
