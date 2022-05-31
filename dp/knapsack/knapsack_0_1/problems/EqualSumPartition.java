package knapsack.knapsack_0_1.problems;

import java.util.Arrays;

public class EqualSumPartition {

    public static boolean isEqualPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        return isSubSetSum(nums, nums.length, sum / 2);
    }

    public static boolean isSubSetSum(int[] nums, int n, int target) {
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (j == 0) dp[i][j] = true;
                else if (nums[i - 1] <= j) dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        // true (11,11)
        System.out.println(isEqualPartition(nums));
        int[] nums2 = {1, 5, 11, 5, 1};
        // false
        System.out.println(isEqualPartition(nums2));

    }
}
