package BinarySearchTree;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
 * <p>
 * Note:
 * <p>
 * A subtree must include all of its descendants.
 * <p>
 * Input: [10,5,15,1,8,null,7]
 * <p>
 * 10
 * / \
 * 5  15
 * / \   \
 * 1   8   7
 * <p>
 * Output: 3
 * Explanation: The Largest BST Subtree in this case is the subtree [5,1,8]. The return value is the subtree's size,
 * which is 3.
 */
public class LargestBSTSubTree {
    private static int maxSize;

    public static int largest(TreeNode root) {
        if (root == null)
            return 0;
        maxSize = 0;
        dfs(root);
        return maxSize;
    }

    public static SubTreeData dfs(TreeNode root) {
        if (root == null)
            return null;
        SubTreeData left = dfs(root.left);
        SubTreeData right = dfs(root.right);
        if ((left == null || (left.isBST && left.max < root.val)) &&
                (right == null || (right.isBST && right.min > root.val))) {
            int currentSize = (left == null ? 0 : left.size) + (right == null ? 0 : right.size) + 1;
            maxSize = Math.max(maxSize, currentSize);
            int newMin = left == null ? root.val : left.min;
            int newMax = right == null ? root.val : right.max;
            return new SubTreeData(true, currentSize, newMin, newMax);
        }
        return new SubTreeData(false, 0, 0, 0);
    }

    public static void main(String[] args) {
        System.out.println(largest(new TreeNode(10, new TreeNode(5, new TreeNode(1),
                new TreeNode(8)),
                new TreeNode(15, null, new TreeNode(7)))));
    }

    static class SubTreeData {
        int size;
        boolean isBST;
        int max;
        int min;

        public SubTreeData(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
}
