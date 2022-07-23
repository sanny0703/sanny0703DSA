package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two binary search trees,
 * return True if and only if
 * there is a node in the first tree and a node in the second tree whose values sum up to a given integer target.
 * <p>
 * <p>
 * Example 1:
 * 2     1
 * / \   / \
 * 1   4 0   3
 * <p>
 * Input: root1 = [2,1,4], root2 = [1,0,3], target = 5
 * Output: true
 * Explanation: 2 and 3 sum up to 5.
 */
public class TwoSumBstS {
    public static boolean isSum(TreeNode root1, TreeNode root2, int k) {
        List<Integer> list1 = new ArrayList<>();
        inorder(root1, list1);
        List<Integer> list2 = new ArrayList<>();
        inorder(root2, list2);
        int lo = 0, hi = list2.size();
        while (lo < list1.size() && hi >= 0) {
            int sum = list1.get(lo) + list2.get(hi);
            if (sum == k)
                return true;
            if (sum > k)
                hi--;
            else lo++;
        }
        return false;
    }

    public static void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
