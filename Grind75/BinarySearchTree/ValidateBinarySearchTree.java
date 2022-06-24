package BinarySearchTree;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <br>
 * <br>
 * A valid BST is defined as follows:
 * <br>
 * <br>
 * The left subtree of a node contains only nodes with keys less than the node's key.<br>
 * The right subtree of a node contains only nodes with keys greater than the node's key.<br>
 * Both the left and right subtrees must also be binary search trees.<br>
 * <br>
 * <br>
 * <code>
 * Input: root = [2,1,3]<br>
 * Output: true
 * </code>
 */
public class ValidateBinarySearchTree {
    public static boolean isBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(isBST(root));
    }
}
