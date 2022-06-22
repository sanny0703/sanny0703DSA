package DynamicProgramming.JumpGame;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * <br>
 * and each element in the array represents your maximum jump length at that position.
 * <br>
 * Return true if you can reach the last index, or false otherwise.
 */
public class Recursion {
    public static boolean canJump(int[] nums) {
        int n = nums.length - 1;
        if (n == 1) return true;
        return helper(nums, 0, n);
    }

    public static boolean helper(int[] nums, int cur, int n) {
        if (cur >= n) return false;
        if (cur == n - 1) return true;
        for (int i = 1; i <= nums[cur]; i++) {
            if (helper(nums, cur + i, n)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // true
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
