package BinarySearchTree;

/**
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 * <br>
 * <br>
 * <code>
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 * </code>
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static TreeNode toTree(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        return helper(arr, l, r);
    }

    public static TreeNode helper(int[] arr, int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = helper(arr, l, mid - 1);
        root.right = helper(arr, mid + 1, r);
        return root;
    }

}
