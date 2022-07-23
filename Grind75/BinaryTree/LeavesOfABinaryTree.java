package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this:
 *     Collect and remove all leaves, repeat until the tree is empty.
 *
 *  Example:
 *
 *  Input: [1,2,3,4,5]
 *
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 *
 *  Output: [[4,5,3],[2],[1]]
 */
public class LeavesOfABinaryTree {
    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        dfs(root, list);
        return list;
    }

    public static int dfs(TreeNode root, List<List<Integer>> list) {
        if (root == null) return -1;
        int left = dfs(root.left, list);
        int right = dfs(root.right, list);
        int currentDepthFromBottom = Math.max(left, right) + 1;
        // this code is reached first only when ths recursive call is in last level
        if (list.size() <= currentDepthFromBottom) list.add(new ArrayList<>());
        list.get(currentDepthFromBottom).add(root.val);
        return currentDepthFromBottom;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println(findLeaves(root));
    }
}
