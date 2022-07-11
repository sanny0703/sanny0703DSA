package BacktrackingAndRecursion;

import java.util.Arrays;

/**
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 * <p>
 * For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 * <p>
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 * <p>
 * The replacement must be in place and use only constant extra memory.
 * <p>
 * <p>
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 */
public class NextPermutation {
    public static int[] next(int[] nums) {
        int n = nums.length;
        //we just want to find the next permutation not the greatest permutation
        //1) from th last find the first non-increasing element
        //2) swap it with the element to it's right and just grater than itself
        //3) reverse the part right to it after swapping(because they are decreasing order)
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[i] >= nums[j])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(next(new int[]{1, 2, 3})));
    }
}
