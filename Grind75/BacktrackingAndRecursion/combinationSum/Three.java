package BacktrackingAndRecursion.combinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * <br>
 * Only numbers 1 through 9 are used.<br>
 * Each number is used at most once.<br>
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 * <br>
 * <br>
 * <code>
 * Input: k = 3, n = 9
 * <br>
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * <br>
 * Explanation:
 * <br>
 * 1 + 2 + 6 = 9
 * <br>
 * 1 + 3 + 5 = 9
 * <br>
 * 2 + 3 + 4 = 9
 * <br>
 * There are no other valid combinations.
 * </code>
 */
public class Three {
    public static List<List<Integer>> combinations(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(1, n, k, ans, new ArrayList<>());
        return ans;
    }

    public static void backtrack(int index, int target, int k, List<List<Integer>> ans, List<Integer> curList) {
        if (target < 0)
            return;
        if (target == 0) {
            if (curList.size() == k) ans.add(new ArrayList<>(curList));
            return;
        }
        for (int i = index; i <= 9; i++) {
            curList.add(i);
            backtrack(i + 1, target - i, k, ans, curList);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinations(3, 9));
    }
}
