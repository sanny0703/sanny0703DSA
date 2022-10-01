package BinaryTree.PathSum;

import BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 * <br>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 * <br>
 * <br>
 * <code>
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8<br>
 * Output: 3
 * </code>
 */
public class Three {
    static int count;
    static Map<Integer, Integer> map;

    public static int countSum(TreeNode root, int target) {
        count = 0;
        map = new HashMap<>();
        map.put(0, 1);// when target is 0, then {}
        if (root == null) return 0;
        helper(root, root.val, target);
        return count;
    }

    public static void helper(TreeNode root, int curSum, int targetSum) {
        if (map.containsKey(curSum - targetSum))
            count += map.get(curSum - targetSum);
        if (map.containsKey(curSum))
            map.put(curSum, map.get(curSum) + 1);
        else map.put(curSum, 1);

        if (root.left != null) {
            helper(root.left, curSum + root.left.val, targetSum);
        }
        if (root.right != null) {
            helper(root.right, curSum + root.right.val, targetSum);
        }

        if (map.get(curSum) == 1)
            map.remove(curSum);
        else map.put(curSum, map.get(curSum) - 1);
    }

    public static int efficient(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1); // sum 0 occurred 1 time
        return dfs(root, 0, targetSum, prefixSum);
    }

    private static int dfs(TreeNode root, int curSum, int targetSum, Map<Integer, Integer> prefixSum) {
        if (root == null)
            return 0;
        curSum += root.val;
        int count = prefixSum.getOrDefault(curSum - targetSum, 0);
        prefixSum.put(curSum, prefixSum.getOrDefault(curSum, 0) + 1);
        count += dfs(root.left, curSum, targetSum, prefixSum);
        count += dfs(root.right, curSum, targetSum, prefixSum);
        prefixSum.put(curSum, prefixSum.get(curSum) - 1); // once that particular branch is visited, we don't have the
        // curSum in other branches
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11)));
        System.out.println(countSum(root, 8));
        System.out.println(efficient(root, 8));
    }
}
