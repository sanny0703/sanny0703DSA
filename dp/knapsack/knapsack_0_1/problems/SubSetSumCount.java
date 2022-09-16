package knapsack.knapsack_0_1.problems;

/**
 * Given an array of numbers ,find the count of subsets that are having sum equal to the target
 */
public class SubSetSumCount {
    public static int count(int[] nums, int n, int target) {

        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (j == 0) dp[i][j] = 1;
                else if (nums[i - 1] <= j) dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][target];

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 6, 8, 10};
        // 3{(2,3,5),(10),(2,8)}
        System.out.println(count(nums, 6, 10));

        int[] nums2 = {3, 3, 3, 3};
        //6
        System.out.println(count(nums2, 4, 6));
    }
}
