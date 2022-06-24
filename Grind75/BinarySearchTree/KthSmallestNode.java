package BinarySearchTree;

import java.util.Stack;

/**
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * <br>
 * <br>
 * <code>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * <br>
 * Output: 3
 * </code>
 */
public class KthSmallestNode {
    /**
     * one obvious approach will be to maintain a list and do inorder traversal and return the k-1 the element of the list<br>
     * TC:O(N)<br>
     * SC:O(N)<br>
     * <br>
     * here we will be using a stack just to search the left subtree of root ,and we still weren't able to
     * find the k th node,then we move to right<br>
     * TC:O(H+k) H: height of the tree for going all the way of left subtree<br>
     * SC:O(k) at any point stack only holds k elements
     */
    public static int kThSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
        System.out.println(kThSmallest(root, 3));
    }
}
