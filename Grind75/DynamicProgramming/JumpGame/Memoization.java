package DynamicProgramming.JumpGame;

import java.util.Arrays;

public class Memoization {
    static int[] dp;

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, 0, n);
    }

    public static boolean helper(int[] nums, int cur, int n) {
        if (dp[cur] != -1)
            return dp[cur] == 1;
        if (cur >= n) return false;
        if (cur == n - 1) {
            dp[cur] = 1;
            return true;
        }
        for (int i = 1; i <= nums[cur]; i++) {
            if (helper(nums, cur + i, n)) {
                dp[cur] = 1;
                return true;
            }
        }
        dp[cur] = 0;
        return false;
    }

    public static void main(String[] args) {
        // true
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
