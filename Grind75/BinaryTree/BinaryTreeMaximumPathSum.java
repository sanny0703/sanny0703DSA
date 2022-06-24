package BinaryTree;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * <br>
 * The path sum of a path is the sum of the node's values in the path.
 * <br>
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * <br>
 * <br>
 * <code>
 * Input: root = [1,2,3]<br>
 * Output: 6<br>
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * </code>
 */
public class BinaryTreeMaximumPathSum {
    static int res;

    public static int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }

    public static int helper(TreeNode root) {
        if (root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        int temp = Math.max(Math.max(l, r) + root.val, root.val);
        int ans = Math.max(temp, root.val + l + r);
        res = Math.max(ans, res);
        return temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        //42
        System.out.println(maxPathSum(root));
    }
}
