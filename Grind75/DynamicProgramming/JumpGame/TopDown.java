package DynamicProgramming.JumpGame;

public class TopDown {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        int[] dp = new int[n];
        dp[n - 1] = 1; // we know when we reach end ,then can Jump
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (dp[i + j] == 1) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[0] == 1;
    }

    public static void main(String[] args) {
        // true
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
