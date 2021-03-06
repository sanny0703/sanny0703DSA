package BinaryTree;

/**
 * Given the root of a binary tree, find the maximum average value of any subtree of that tree.
 * <p>
 * (A subtree of a tree is any node of that tree plus all its descendants.
 * The average value of a tree is the sum of its values, divided by the number of nodes.)
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [5,6,1]
 * Output: 6.00000
 * Explanation:
 * For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
 * For the node with value = 6 we have an average of 6 / 1 = 6.
 * For the node with value = 1 we have an average of 1 / 1 = 1.
 * So the answer is 6 which is the maximum.
 * <p>
 * <p>
 * Note:
 * The number of nodes in the tree is between 1 and 5000.
 * Each node will have a value between 0 and 100000.
 * Answers will be accepted as correct if they are within 10^-5 of the correct answer.
 */
public class MaxAverageSubtree {
    private static double max;

    public static double maxAverage(TreeNode root) {
        max = Double.MIN_VALUE;
        dfs(root);
        return max;
    }

    public static double[] dfs(TreeNode root) {
        if (root == null)
            return new double[]{0, 0};
        double[] left = dfs(root.left);
        double[] right = dfs(root.right);
        double sum = left[0] + right[0] + root.val;
        double count = left[1] + right[1] + 1;
        max = Math.max(sum / count, max);
        return new double[]{sum, count};
    }
}
