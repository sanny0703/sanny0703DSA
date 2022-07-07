package Binary;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++)
            // 0^N = N
            //N^N =0
            ans ^= nums[i];
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
