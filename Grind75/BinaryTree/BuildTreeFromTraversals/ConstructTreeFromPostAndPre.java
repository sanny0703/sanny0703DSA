package BinaryTree.BuildTreeFromTraversals;

import BinaryTree.TreeNode;
import BinaryTree.TreeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.
 * <p>
 * If there exist multiple answers, you can return any of them.
 */
public class ConstructTreeFromPostAndPre {
    private static int preIndex = 0, postIndex = 0;

    public static TreeNode construct(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (root.val != postorder[postIndex]) {
            root.left = construct(preorder, postorder);
        }
        if (root.val != postorder[postIndex]) {
            root.right = construct(preorder, postorder);
        }
        postIndex++;
        return root;
    }

    public static TreeNode efficientMethod(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postorderIndexMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) postorderIndexMap.put(postorder[i], i);
        return helper(preorder, 0, preorder.length - 1, postorderIndexMap, 0, postorder.length - 1);
    }

    private static TreeNode helper(int[] preorder, int preorderStartIndex, int preorderEndIndex,
                                   Map<Integer, Integer> postorderIndexMap, int postorderStartIndex,
                                   int postorderEndIndex) {
        if (preorderStartIndex > preorderEndIndex || postorderStartIndex > postorderEndIndex)
            return null;
        TreeNode root = new TreeNode(preorder[preorderStartIndex]);
        if (preorderStartIndex + 1 <= preorderEndIndex) {
            int deltaIndex = postorderIndexMap.get(preorder[preorderStartIndex + 1]) - postorderStartIndex;
            root.left = helper(preorder, preorderStartIndex + 1, preorderStartIndex + 1 + deltaIndex, postorderIndexMap,
                    postorderStartIndex, deltaIndex + postorderStartIndex);
            root.right = helper(preorder, preorderStartIndex + 1 + deltaIndex + 1, preorderEndIndex, postorderIndexMap,
                    deltaIndex + 1 + postorderStartIndex, postorderEndIndex - 1);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] postorder = new int[]{4, 5, 2, 6, 3, 1};
        int[] preorder = new int[]{1, 2, 4, 5, 3, 6};
        TreeUtils.printTree(construct(preorder, postorder));
        TreeUtils.printTree(efficientMethod(preorder, postorder));
    }

}
