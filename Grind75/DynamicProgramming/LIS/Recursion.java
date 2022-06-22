package DynamicProgramming.LIS;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * <br>
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 * <br>
 * <br>
 * <code>
 * Input: nums = [10,9,2,5,3,7,101,18]
 * <br>
 * Output: 4
 * <br>
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * </code>
 */
public class Recursion {
    public static int LIS(int[] nums, int cur, int prev) {
        if (cur == nums.length) return 0; // base case
        int include = Integer.MIN_VALUE;
        if (prev == -1 || nums[prev] < nums[cur])
            include = 1 + LIS(nums, cur + 1, cur); // if we choose to include
        int ignore = LIS(nums, cur + 1, prev); // if we choose not to
        return Math.max(include, ignore);
    }

    public static void main(String[] args) {
        System.out.println(LIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 0, -1));
    }
}
