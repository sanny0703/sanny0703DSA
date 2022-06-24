package BinaryTree;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <br>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as
 * descendants (where we allow a node to be a descendant of itself).”
 * <br>
 * <br>
 * <code>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * <br>
 * Output: 3
 * <br>
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * </code>
 */
public class LowestCommonAncestor {
    public static TreeNode LCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) return root;
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        System.out.println(LCA(root, 5, 1).val);
    }
}
