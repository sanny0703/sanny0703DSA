package BinarySearchTree;

/**
 * Given a Binary Search Tree (BST) with root node root, and a target value V,
 * split the tree into two subtrees where one subtree has nodes that are all smaller or equal to the target value,
 * while the other subtree has all nodes that are greater than the target value. It’s not necessarily the case that the tree contains a node with value V.
 * <p>
 * Additionally, most of the structure of the original tree should remain. Formally, for any child C with parent P in the original tree,
 * if they are both in the same subtree after the split, then node C should still have the parent P.
 * </p>
 * You should output the root TreeNode of both subtrees after splitting, in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [4,2,6,1,3,5,7], V = 2
 * Output: [[2,1],[4,3,6,null,null,5,7]]
 * Explanation:
 * Note that root, output[0], and output[1] are TreeNode objects, not arrays.
 * <p>
 * The given tree [4,2,6,1,3,5,7] is represented by the following diagram:
 * <p>
 * 4
 * /   \
 * 2      6
 * / \    / \
 * 1   3  5   7
 * <p>
 * while the diagrams for the outputs are:
 * <p>
 * 4
 * /   \
 * 3      6      and    2
 * / \           /
 * 5   7         1
 */
public class SplitBST {
    public static TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null)
            return new TreeNode[]{null, null};
        if (root.val > target) { // if target < root.val then just go left to search for it
            TreeNode[] res = splitBST(root.left, target);
            root.left = res[1]; // after removing the nodes update the left subtree
            return new TreeNode[]{res[0], root};
        } else { // similarly go right if target > root.val
            TreeNode[] res = splitBST(root.right, target);
            root.right = res[0]; // after removing those nodes update the right subtree
            return new TreeNode[]{root, res[1]};
        }
    }

}
