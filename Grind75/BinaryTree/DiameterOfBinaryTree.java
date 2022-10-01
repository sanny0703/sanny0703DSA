package BinaryTree;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * <br>
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <br>
 * The length of a path between two nodes is represented by the number of edges between them.
 * <br>
 * <br>
 * <code>
 * Input: root = [1,2,3,4,5]<br>
 * Output: 3<br>
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * </code>
 */
public class DiameterOfBinaryTree {
    private static int ans;

    public static int diameter(TreeNode root) {
        ans = Integer.MIN_VALUE;
        height(root);
        return ans;
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        ans = Math.max(ans, l + r); // compare with previous nodes diameter
        return Math.max(l, r) + 1;
    }

    public static int withoutGlobalParam(TreeNode root) {
        return helper(root)[0];
    }

    private static int[] helper(TreeNode root) {
        if (root == null)
            return new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int currentPossibleDiameter = left[1] + right[1]; // height(root.left)+height(root.right)
        int diameter = Math.max(currentPossibleDiameter, Math.max(left[0], right[0])); // max of left dia and right dia and current dia
        int height = Math.max(left[1], right[1]) + 1;
        return new int[]{diameter, height};
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(diameter(root));
        System.out.println(withoutGlobalParam(root));
    }
}
