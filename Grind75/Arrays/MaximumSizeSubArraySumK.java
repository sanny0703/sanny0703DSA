package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
 * If there isn't one, return 0 instead.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * <p>
 * Example 2:
 * <p>
 * Given nums = [-2, -1, 2, 1], k = 1,
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 * <p>
 * Follow Up:
 * Can you do it in O(n) time?
 */
public class MaximumSizeSubArraySumK {
    // only works for positive numbers
    public static int maximum(int[] nums, int k) {
        int n = nums.length;
        int curSum = 0;
        int i = 0, j = 0, max = 0;
        while (j < n) {
            curSum += nums[j];
            if (curSum > k) {
                while (curSum > k) {
                    curSum -= nums[i];
                    i++;
                }
            }
            if (curSum == k)
                max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }

    public static int maximumSubArray(int[] nums, int k) {
        Map<Integer, Integer> prevSums = new HashMap<>();
        int curSum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum == k)
                max = Math.max(max, i + 1); // this means we have our subarray with sum k starting from 0
            // diff+k = curSum
            // that means from diff to curSum ,we got a subarray with sum k
            int diff = curSum - k;
            if (prevSums.containsKey(diff))
                max = Math.max(max, i - prevSums.get(diff));
            if (!prevSums.containsKey(curSum))
                prevSums.put(curSum, i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximumSubArray(new int[]{1, -1, 5, -2, 3}, 3));
    }
}
