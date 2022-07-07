package Binary;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * <p>
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 */
public class MissingNumber {
    public static int missing(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++)
            sum += i - nums[i];
        return sum;
    }

    public static int missingXor(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor ^ i;
    }

    public static void main(String[] args) {
        System.out.println(missing(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println(missingXor(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
