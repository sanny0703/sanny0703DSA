package Arrays;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * <p>
 * Return the sum of the three integers.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public static int closest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; i++) {
            // skipping already found 3sum to increase performance
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1, high = n - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum > target)
                    high--;
                else low++;
                if (Math.abs(res - target) > Math.abs(sum - target))
                    res = sum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(closest(new int[]{-1, 2, 1, -4}, 1));
    }
}
