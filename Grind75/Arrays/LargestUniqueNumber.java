package Arrays;

import java.util.Arrays;

/**
 * Given an array of integers A, return the largest integer that only occurs once.
 * <p>
 * If no integer occurs once, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: [5,7,3,9,4,9,8,3,1]
 * <p>
 * Output: 8
 */
public class LargestUniqueNumber {
    public static int largest(int[] nums) {
        Arrays.sort(nums);
        // the loop doesn't take care of edges i.e. 0 and n-1 ,so take care of them separately
        if (nums[nums.length - 1] != nums[nums.length - 2])
            return nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i--) {
            int prev = nums[i - 1], cur = nums[i], next = nums[i + 1];
            if (cur != prev && cur != next)
                return cur;
        }
        if (nums[0] != nums[1])
            return nums[0];
        return -1; // if we can't find unique number in the array
    }

    public static void main(String[] args) {
        System.out.println(largest(new int[]{5, 7, 3, 9, 4, 9, 8, 3, 1}));
    }
}
