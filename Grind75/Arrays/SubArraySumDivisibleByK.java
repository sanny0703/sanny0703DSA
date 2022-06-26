package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
 * <p>
 * A subarray is a contiguous part of an array.
 * <p>
 * Input: nums = [4,5,0,-2,-3,1], k = 5
 * Output: 7
 * Explanation: There are 7 subarray with a sum divisible by k = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 */
public class SubArraySumDivisibleByK {
    public static int count(int[] nums, int k) {
        Map<Integer, Integer> preReminder = new HashMap<>();
        preReminder.put(0, 1);
        int sum = 0, res = 0;
        for (int num : nums) {
            sum += num;
            int rem = sum % k;
            if (rem < 0) rem += k;
            if (preReminder.containsKey(rem))
                res += preReminder.get(rem);
            preReminder.put(rem, preReminder.getOrDefault(rem, 0) + 1);
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(count(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }
}
