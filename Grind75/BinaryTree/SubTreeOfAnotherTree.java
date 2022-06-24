package BinaryTree;

/**
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 * <br>
 * A subtree of a binary tree is a tree that consists of a node in tree and all of this node's descendants. The  tree could also be considered as a subtree of itself.
 * <br>
 * <br>
 * <code>
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]<br>
 * Output: true
 * </code>
 */
public class SubTreeOfAnotherTree {
    public static boolean isSubTree(TreeNode root, TreeNode subRoot) {
        // constraints are root != null,we are doing this for recursive calls
        if (root == null) return false;
        if (isSame(root, subRoot)) return true;
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    public static boolean isSame(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        return p.val == q.val && isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(isSubTree(root, subRoot));
    }
}
