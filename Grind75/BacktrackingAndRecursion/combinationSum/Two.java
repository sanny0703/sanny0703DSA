package BacktrackingAndRecursion.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * iven a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * <br>
 * Each number in candidates may only be used once in the combination.
 * <br>
 * <br>
 * <code>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Br>
 * Output:
 * Br>
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * </code>
 */
public class Two {
    public static List<List<Integer>> combinations(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, ans, new ArrayList<>(), target);
        return ans;
    }

    public static void backtrack(int index, int[] candidates, List<List<Integer>> ans, List<Integer> curList, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(curList));
            return;
        }
        if (target < 0)
            return;
        for (int i = index; i < candidates.length; i++) {
            // ignore duplicates
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            int pick = candidates[i];
            if (pick <= target) {
                curList.add(pick);
                backtrack(i + 1, candidates, ans, curList, target - pick);
                curList.remove(curList.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(combinations(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
