package DynamicProgramming.CombinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * <br>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * <br>
 * <br>
 * <code>
 * Input: candidates = [2,3,6,7], target = 7
 * <br>
 * Output: [[2,2,3],[7]]
 * <br>
 * Explanation:
 * <br>
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * <br>
 * 7 is a candidate, and 7 = 7.
 * <br>
 * These are the only two combinations.
 * </code>
 */
public class One {
    public static List<List<Integer>> combination(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, candidates, ans, new ArrayList<>(), target);
        return ans;
    }

    public static void helper(int index, int[] candidates, List<List<Integer>> ans, List<Integer> curList, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(curList));
            return;
        }
        if (target < 0)
            return;
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                curList.add(candidates[i]);
                // we are using index because,we can reuse the potential element
                helper(i, candidates, ans, curList, target - candidates[i]);
                curList.remove(curList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combination(new int[]{2, 3, 6, 7}, 7));
    }
}
