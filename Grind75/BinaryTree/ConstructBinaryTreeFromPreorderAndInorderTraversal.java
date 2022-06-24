package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree,
 * construct and return the binary tree.
 * <br>
 * <br>
 * <code>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]<br>
 * Output: [3,9,20,null,null,15,7]
 * </code>
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private static int preorderIndex;
    static Map<Integer, Integer> inorderIndexMap;

    public static TreeNode constructTree(int[] inorder, int[] preorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    public static TreeNode arrayToTree(int[] preorder, int l, int r) {
        if (l > r) return null;
        TreeNode root = new TreeNode(preorder[preorderIndex++]);
        if (l == r) // no child case
            return root;
        root.left = arrayToTree(preorder, l, inorderIndexMap.get(root.val) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(root.val) + 1, r);
        return root;
    }
}
