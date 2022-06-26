package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum {
    public static List<List<Integer>> uniqueSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1, high = n - 1, sum = -nums[i];
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;

                } else if (nums[low] + nums[high] < sum) low++;
                else high--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(uniqueSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
