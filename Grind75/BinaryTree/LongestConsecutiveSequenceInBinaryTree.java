package BinaryTree;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 *
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 *
 * Input:
 *
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 *
 * Output: 3
 *
 * Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
 *
 * Input:
 *
 *    2
 *     \
 *      3
 *     /
 *    2
 *   /
 *  1
 *
 * Output: 2
 *
 * Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
 */
public class LongestConsecutiveSequenceInBinaryTree {
    private static int max;

    public static int longest(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }

    public static int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int ret = 1; // when both left and right are null, then we must at least consider root and return 1
        if (root.left != null && root.val == root.left.val - 1)
            ret = Math.max(ret, 1 + left);
        if (root.right != null && root.val == root.right.val - 1)
            ret = Math.max(ret, 1 + right);
        max = Math.max(max, ret);
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(longest(new TreeNode(1, null, new TreeNode(3, new TreeNode(2), new TreeNode(4, null, new TreeNode(5))))));
        System.out.println(longest(new TreeNode(2, null, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), null))));
    }
}
