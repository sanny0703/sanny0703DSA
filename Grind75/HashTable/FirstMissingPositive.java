package HashTable;

/**
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * <p>
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 * \
 * <p>
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 */
public class FirstMissingPositive {
    // answer is always in 1..n+1;
    // so just ignore negatives,zero and >n
    public static int find(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n)
                nums[i] = n + 1;
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n)
                continue;
            num--; // o indexed 1 is at 0, 2 is at 1 th position
            if (nums[num] > 0) // handle double negation
                nums[num] = -1 * nums[num];
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return n + 1; // it contains all numbers from 1..n
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{7, 8, 9, 11, 12}));
    }
}
