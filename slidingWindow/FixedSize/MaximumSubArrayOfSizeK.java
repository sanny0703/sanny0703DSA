package FixedSize;

import java.util.Arrays;

/**
 * Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.<br>
 * <br>
 * <code> Example:<br>
 * <p>
 * Input:<br>
 * N = 4, K = 2<br>
 * Arr = [100, 200, 300, 400]<br>
 * Output:<br>
 * 700<br>
 * Explanation:<br>
 * Arr3  + Arr4 =700,<br>
 * which is maximum. . </code>
 */
public class MaximumSubArrayOfSizeK {
    public static int[] maxSumSubArray(int[] arr, int k) {
        int curSum = 0;
        for (int i = 0; i < k; i++) curSum += arr[i];
        int x = 0, y = k - 1, max = curSum;
        int i = 0;
        for (int j = k; j < arr.length; j++, i++) {
            curSum = curSum + arr[j] - arr[i];
            if (curSum > max) {
                // since increasing is take care of for loop, we have to add +1 for both i and j to get current values
                x = i + 1;
                y = j + 1;
                max = curSum;
            }
        }
        System.out.println(max);
        return Arrays.copyOfRange(arr, x, y);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSumSubArray(new int[]{100, 200, 300, 400}, 2)));
    }
}
