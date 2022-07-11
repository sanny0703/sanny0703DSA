package BacktrackingAndRecursion.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * O(N * 2^N)
 */
public class Duplicates {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    public static void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> curList, int index) {
        ans.add(new ArrayList<>(curList));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])// skip the duplicates
                continue;
            curList.add(nums[i]);
            backtrack(nums, ans, curList, i + 1);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 2}));
    }
}
