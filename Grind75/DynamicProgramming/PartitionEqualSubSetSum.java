package DynamicProgramming;

import java.util.Arrays;

/**
 * Given a non-empty array nums containing only positive integers,
 * <br>
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * <br>
 * <br>
 * <code>
 * Input: nums = [1,5,11,5]
 * <br>
 * Output: true
 * <br>
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * </code>
 */
public class PartitionEqualSubSetSum {
    public static boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (j == 0) dp[i][j] = true;
                else if (arr[i - 1] <= j) dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    }
}
