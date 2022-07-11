package BacktrackingAndRecursion.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 * <p>
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 *
 *
 * O(N * N!)
 */
public class Duplicates {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, ans, new ArrayList<>(), used);
        return ans;
    }

    public static void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> curList, boolean[] used) {
        if (curList.size() == nums.length) {
            ans.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            curList.add(nums[i]);
            backtrack(nums, ans, curList, used);
            used[i] = false;
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 2}));
    }
}
