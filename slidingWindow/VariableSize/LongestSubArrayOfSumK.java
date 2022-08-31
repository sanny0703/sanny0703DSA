package VariableSize;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array containing N positive integers and an integer K. <br>
 * Your task is to find the length of the longest Sub-Array with sum of the elements equal to the given value K.<br>
 * <br>
 * <code>For Input:<br>
 * 1<br>
 * 7 5<br>
 * 4 1 1 1 2 3 5<br>
 * your output is: <br>
 * 4 . </code>
 */
public class LongestSubArrayOfSumK {
    // this approach won't work for negative numbers
    public static int longestSubArray(int[] arr, int k) {
        int sum = 0;
        int i = 0, j = 0;
        int ans = 0; // variable to store longest subArray length
        while (j < arr.length) {
            sum += arr[j];
            if (sum > k) { // we are doing this first cause after removing prev elements we might hit our window
                while (sum > k) {
                    sum -= arr[i];
                    i++;
                }
            }
            // this will take care of hit and after removing prev elements hit
            if (sum == k) {
                ans = Math.max(ans, j - i + 1);
            }
            j++;
        }
        return ans;
    }

    public static int longestSubArrayEfficient(int[] nums, int k) {
        int n = nums.length, longest = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            curSum += nums[i];
            if (curSum == k)
                longest = i + 1; // longest subarray starting from 0 index
            if (!preSum.containsKey(curSum))
                preSum.put(curSum, i);
            // if sum-k is present in preSum that means the subarray sum from that index to current index is k
            // so update max
            if (preSum.containsKey(curSum - k))
                longest = Math.max(longest, i - preSum.get(curSum - k));
        }
        return longest;
    }

    public static void main(String[] args) {
        //4{1,1,1,2}
        System.out.println(longestSubArray(new int[]{4, 1, 1, 1, 2, 3, 5,}, 5));
        //5{10,33,34,65,89}
        System.out.println(longestSubArray(new int[]{2, 3, 4, 5, 3, 1, 9, 4, 5, 3, 2, 6, 7, 3, 9, 10, 33, 34, 65, 89, 34, 556, 7968, 454}, 231));
        // doesn't work
        System.out.println(longestSubArray(new int[]{1, -1, 5, -2, 3}, 3));
        // works fine
        System.out.println(longestSubArrayEfficient(new int[]{1, -1, 5, -2, 3}, 3));
    }
}
