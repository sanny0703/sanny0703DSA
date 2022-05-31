package knapsack.knapsack_0_1.problems;

import java.util.Arrays;

/***
 * <b>count the no of ways in which the arr can be split into two subsets such that the diff of their sum is equal to diff </b>
 * <br>
 * this problem reduces to <b>SubSetSumCount</b> <br>
 * <code>S1-S2 = diff<br>
 * S1+S2 = sum<br>
 * 2S1 = diff+sum<br>
 * S1 = (diff+sum)/2
 * </code>
 */
public class CountSubSetSumDiff {

    public static int count(int[] nums, int n, int diff) {
        int sum = Arrays.stream(nums).sum();
        int target = (diff + sum) / 2;
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
        int[] nums = {1, 1, 2, 3};
        int diff = 1;
        // 3
        System.out.println(count(nums, 4, 1));
    }
}
