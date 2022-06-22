package DynamicProgramming;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) <br>
 * which has the largest sum and return its sum.
 * <br>
 * <br>
 * <code>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * <br>
 * Output: 6
 * <br>
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * </code>
 */
public class MaximumSumSubArray {
    public static int maxSubArray(int[] arr) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        int curSum = 0;
        int i = 0, j = 0;
        while (j < n) {
            curSum += arr[j];
            ans = Math.max(ans, curSum);
            if (curSum < 0) {
                while (curSum < 0) {
                    curSum -= arr[i];
                    i++;
                }
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
