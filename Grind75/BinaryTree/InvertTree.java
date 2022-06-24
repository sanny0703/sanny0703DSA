package BinaryTree;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 * <br>
 * <br>
 * <code>
 * Input: root = [4,2,7,1,3,6,9]<br>
 * Output: [4,7,2,9,6,3,1]
 * </code>
 */
public class InvertTree {
    public static TreeNode invert(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        root.left = invert(root.left);
        root.right = invert(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
        TreeUtils.printTree(root);
        System.out.println();
        root = invert(root);
        TreeUtils.printTree(root);
        System.out.println();
    }
}
