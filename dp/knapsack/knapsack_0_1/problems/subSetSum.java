package knapsack.knapsack_0_1.problems;

public class subSetSum {

    public static boolean isSum(int[] nums, int n, int target) {
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (i == 0) dp[i][j] = false;
                else if (j == 0) dp[i][j] = true;
                else if (nums[i - 1] <= j) dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = {3, 34, 4, 12, 5, 2};
        int target = 9;
        // true
        System.out.println(isSum(nums, nums.length, target));
        int[] nums2 = {3, 34, 4, 12, 5, 2};
        int target2 = 30;
        // false
        System.out.println(isSum(nums2, nums2.length, target2));
    }
}
