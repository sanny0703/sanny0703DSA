package BinarySearchTree;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * <p>
 * Note:
 * <p>
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * <p>
 * Input: root = [4,2,5,1,3], target = 3.714286
 * <p>
 *     4
 *    / \
 *   2   5
 *  / \
 * 1  3
 * <p>
 * Output: 4
 */
public class ClosestBinarySearchTreeValue {
    public static int closest(TreeNode root, double value) {
        TreeNode closestChild = value > root.val ? root.right : root.left;
        if (closestChild == null)
            return root.val;
        int closestChildValue = closest(closestChild, value);
        return Math.abs(root.val - value) < Math.abs(closestChildValue - value) ? root.val : closestChildValue;
    }

    public static void main(String[] args) {
        System.out.println(closest(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5)), 3.712));
        System.out.println(closest(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5)), 3.12));
    }
}
