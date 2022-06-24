package BinaryTree.PathSum;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 * <br>
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 * <br>
 * <br>
 * <code>
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22<br>
 * Output: [[5,4,11,2],[5,8,4,5]]<br>
 * Explanation: There are two paths whose sum equals targetSum:<br>
 * 5 + 4 + 11 + 2 = 22<br>
 * 5 + 8 + 4 + 5 = 22
 * </code>
 */
public class Two {
    public static List<List<Integer>> howSum(TreeNode root, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        sum(root, ans, new ArrayList<>(), target);
        return ans;
    }

    public static void sum(TreeNode root, List<List<Integer>> ans, List<Integer> curList, int target) {
        if (root == null)
            return;
        target -= root.val;
        curList.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(curList));
        }

        sum(root.left, ans, curList, target);
        sum(root.right, ans, curList, target);
        curList.remove(curList.size() - 1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        System.out.println(howSum(root, 22));
    }
}
