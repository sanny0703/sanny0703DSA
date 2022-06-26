package Arrays;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number
 * sorted in non-decreasing order.
 * <p>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 */
public class SquaresOfSortedArray {
    public static int[] squares(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int[] ans = new int[n];
        int index = n - 1;
        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                ans[index] = nums[l] * nums[l];
                index--;
                l++;
            } else {
                ans[index] = nums[r] * nums[r];
                index--;
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(squares(new int[]{-4, -1, 0, 3, 10})));
    }
}
