package Arrays.MajorityElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * <p>
 * Input: nums = [3,2,3]
 * Output: [3]
 *
 * Boyer-Moore Voting Algorithm
 */
public class Two {
    public static List<Integer> majority(int[] nums) {
        int n = nums.length;
        int num1 = nums[0], num2 = nums[0], count1 = 0, count2 = 0; // since there can be only two  elements greater than n/3
        for (int i = 0; i < n; i++) {
            if (nums[i] == num1) count1++;
            else if (nums[i] == num2) count2++;
            else if (count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
            count1 = 0;
            count2 = 0;

        }
        for (int i = 0; i < n; i++) {
            if (num1 == nums[i]) count1++;
            else if (num2 == nums[i]) count2++;
        }
        List<Integer> ans = new ArrayList<>();
        if (count1 > n / 3) ans.add(num1);
        if (count2 > n / 3) ans.add(num2);
        return ans;
    }
}
