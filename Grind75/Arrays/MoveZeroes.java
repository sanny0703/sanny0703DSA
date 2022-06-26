package Arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeroes {
    public static int[] move(int[] nums) {
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < n; i++) {
            nums[i] = 0;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(move(new int[]{0, 1, 0, 3, 12})));
    }
}
