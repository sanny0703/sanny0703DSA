package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 * <p>
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */
public class ContiguousArray {
    // the idea here we will replace all 0's with -1 and find the largest subarray with sum 0
    // if count of -1 and 1 is equal then sum is 0
    public static int longestSubArray(int[] nums) {
        int n = nums.length;
        int sum = 0, longest = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);//at -1 th index we have sum 0 i.e. nothing
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                //if we got sum=0 at index 2 map already has 0,-1  now 2-(-1)=3
                longest = Math.max(longest, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestSubArray(new int[]{0, 1, 0}));
    }
}
