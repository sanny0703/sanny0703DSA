package Arrays;

import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * <p>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * <p>
 * You must solve this problem without using the library's sort function.
 * <p>
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
public class SortColors {
    //one pass
    public static void sort1(int[] nums) {
        int n = nums.length;
        int p1 = 0, index = 0, p2 = n - 1;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--; // we are doing this so index stays where it is
            }
            index++;
        }

    }

    public static void sort2(int[] nums) {
        int n = nums.length;
        int count = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == 0) count++;
            else if (num == 1) count1++;
            else count2++;
        }
        for (int i = 0; i < n; i++) {
            if (i < count) nums[i] = 0;
            else if (i < count + count1) nums[i] = 1;
            else nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
//        sort1(nums);
//        System.out.println(Arrays.toString(nums));
        sort2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
