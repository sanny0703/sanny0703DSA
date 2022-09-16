package DynamicProgramming;

/**
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product,
 * and return the product.
 * <br>
 * <br>
 * <code>
 * Input: nums = [2,3,-2,4]
 * <br>
 * Output: 6
 * <br>
 * Explanation: [2,3] has the largest product 6.
 * </code>
 */
public class MaximumProductSubArray {

    public static int maxSubArray(int[] arr) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        int product = 1;
        for (int j : arr) {
            product *= j;
            ans = Math.max(ans, product);
            if (product == 0)
                product = 1;
        }
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            product *= arr[i];
            ans = Math.max(ans, product);
            if (product == 0)
                product = 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{2, 3, -2, 4}));
    }
}
