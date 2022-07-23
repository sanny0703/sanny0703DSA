package Arrays;

/**
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * <p>
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 * Input: nums = [3,4,-1,1]
 * Output: 2
 */
public class FirstMissingPositive {
    public static int firstMissing(int[] nums) {
        // we only consider those are positive and in the array(n)
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) nums[i] = n + 1;
        }
        // all those positives which are present inside array ,mark them as negative
        for (int i = 0; i < n; i++) {
            int k = Math.abs(nums[i]);
            if (k > n) continue;
            k--;
            if (nums[k] > 0)
                nums[k] = -1 * nums[k];
        }
        // just return the first non-negative index+1
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        return n + 1;// when 1...n are present inside the array
    }

    public static void main(String[] args) {
        System.out.println(firstMissing(new int[]{3, 4, -1, 1}));
    }
}
