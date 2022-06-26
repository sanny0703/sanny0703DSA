package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 */
public class SubArraySumEqualsK {
    public static int count(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1); // preSum when no element is taken
        int sum = 0, res = 0;
        for (int num : nums) {
            sum += num;
            if (preSum.containsKey(sum - k))
                res += preSum.get(sum - k);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(count(new int[]{1, 1, 1}, 2));
    }
}
