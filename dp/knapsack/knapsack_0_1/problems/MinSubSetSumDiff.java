package knapsack.knapsack_0_1.problems;

import java.util.ArrayList;
import java.util.List;

/***
 * split the arr in to two subsets such that difference between their sums is minimum
 */
public class MinSubSetSumDiff {
    /***
     *
     * the idea here is to make use of the last row of dp<code>(length:n and sum:j)</code>
     * because all are not valid sums, so take only valid sums in to consideration
     *
     * no, we just have to find the <code>dp[n][j]= true</code>, closest to <code>sum/2</code> such that  <code>sum-2*j</code> will be minimum, which
     * boils down to finding the <b>first</b> true before <code>sum/2</code>
     */
    public static int miSubSetSumDiff(int[] nums, int n, int sum) {
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (j == 0) dp[i][j] = true;
                else if (nums[i - 1] <= j) dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        int ans = 0;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                ans = sum - 2 * j;
                break;
            }

        }
        return ans;

    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 7};
        // 4  {7-(2+1)}
        System.out.println(miSubSetSumDiff(nums, 3, 10));

        int[] nums2 = {1, 6, 11, 5};
        //1 {12(1+6+5)-11}
        System.out.println(miSubSetSumDiff(nums2, 4, 23));
    }
}
