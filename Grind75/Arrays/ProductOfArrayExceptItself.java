package Arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * <p>
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptItself {
    // at any point product[i]= left*right
    //first calculate left and then multiply with right
    public static int[] product(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0)
                left = left * nums[i - 1];
            res[i] = left;
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1)
                right = right * nums[i + 1];
            res[i] = res[i] * right; // left * right
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(product(new int[]{-1, 1, 0, -3, 3})));
    }
}
