package BacktrackingAndRecursion.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class NoDuplicates {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    public static void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> curList, int index) {
        ans.add(new ArrayList<>(curList)); // no matter size a subset is a subset
        for (int i = index; i < nums.length; i++) {
            curList.add(nums[i]);
            backtrack(nums, ans, curList, i + 1); // set, we can't re-use the same element
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
