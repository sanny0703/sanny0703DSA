package BinarySearchTree;

/**
 * LCA of a Binary Search Tree
 * <br>
 * <br>
 * <code>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * <br>
 * Output: 6
 * <br>
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * </code>
 */
public class LowestCommonAncestor {
    public static TreeNode LCA(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val < p && root.val < q) return LCA(root.right, p, q); // completely right
        if (root.val > p && root.val > q) return LCA(root.left, p, q); // completely left
        return root; // may be either side of root are p,q (or) root is p and q is on one of the side (or) root is q and p is on one of the side
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        System.out.println(LCA(root, 2, 8).val);
    }
}
