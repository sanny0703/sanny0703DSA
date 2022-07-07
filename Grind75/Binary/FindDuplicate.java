package Binary;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * <p>
 * There is only one repeated number in nums, return this repeated number.
 * <p>
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * <p>
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 */
public class FindDuplicate {
    public static int duplicate(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int next = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = next;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(duplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
