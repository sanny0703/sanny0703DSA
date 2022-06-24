package BinaryTree.PathSum;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * <br>
 * <br>
 * <code>
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22<br>
 * Output: true
 * </code>
 */
public class One {
    public static boolean canSum(TreeNode root, int target) {
        if (root == null) return false;
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) return true;
        return canSum(root.left, target) || canSum(root.right, target);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        System.out.println(canSum(root, 22));

    }
}
