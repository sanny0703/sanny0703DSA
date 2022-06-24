package BinaryTree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <br>
 * For this problem, a height-balanced binary tree is defined as:
 * <br>
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * <br>
 * <br>
 * <code>
 * Input: root = [3,9,20,null,null,15,7]<br>
 * Output: true
 * </code>
 */
public class BalancedBinaryTree {
    private static boolean balanced;

    public static boolean isBalanced(TreeNode root) {
        balanced = true;
        height(root);
        return balanced;
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        if (Math.abs(l - r) > 1)
            balanced = false;
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(17)));
        System.out.println(isBalanced(root));
    }
}
