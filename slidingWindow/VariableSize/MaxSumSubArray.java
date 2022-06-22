package VariableSize;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums, <br>
 * find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <br>
 * <br>
 * <code>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]<br>
 * Output: 6<br>
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * </code>
 */
public class MaxSumSubArray {
    public static List<Integer> maxSubArray(int[] arr) {
        int ans = Integer.MIN_VALUE;
        int start = 0, end = 0;
        int i = 0, j = 0;
        int curSum = 0;
        while (j < arr.length) {
            curSum += arr[j];
            // we are doing it heere ,to handle the case where only negative numbers are present in array
            if (curSum > ans) {
                ans = curSum;
                start = i;
                end = j;
            }
            if (curSum < 0) {
                while (curSum < 0) {
                    curSum -= arr[i];
                    i++;
                }
            }

            j++;
        }
        List<Integer> list = new ArrayList<>();
        for (int k = start; k <= end; k++) list.add(arr[k]);
        System.out.println(ans);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
