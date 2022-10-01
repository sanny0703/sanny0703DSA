package BinaryTree.BuildTreeFromTraversals;

import BinaryTree.TreeNode;
import BinaryTree.TreeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Construct binary tree from postorder and inorder traversals  of the tree
 */
public class ConstructTreeFromPostAndIn {
    private static int postorderIndex;

    public static TreeNode construct(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) inorderIndexMap.put(inorder[i], i);
        postorderIndex = n - 1;
        return dfs(postorder, 0, n - 1, inorderIndexMap);
    }

    public static TreeNode dfs(int[] postorder, int l, int r, Map<Integer, Integer> inorderIndexMap) {
        if (l > r) return null;
        TreeNode root = new TreeNode(postorder[postorderIndex--]);
        if (l == r) return root;
        root.right = dfs(postorder, inorderIndexMap.get(root.val) + 1, r, inorderIndexMap);
        root.left = dfs(postorder, l, inorderIndexMap.get(root.val) - 1, inorderIndexMap);
        return root;
    }

    public static TreeNode efficientMethod(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inorderIndexMap.put(inorder[i], i);
        return helper(postorder, 0, postorder.length - 1, inorderIndexMap, 0,
                inorder.length - 1);
    }

    private static TreeNode helper(int[] postorder, int postorderStartIndex, int postorderEndIndex, Map<Integer,
            Integer> inorderIndexMap, int inorderStartIndex, int inorderEndIndex) {
        if (postorderStartIndex > postorderEndIndex || inorderStartIndex > inorderEndIndex)
            return null;
        TreeNode root = new TreeNode(postorder[postorderEndIndex]);
        int inorderIndex = inorderIndexMap.get(root.val);
        int nodesLeft = inorderIndex - inorderStartIndex;
        root.right = helper(postorder, postorderStartIndex + nodesLeft, postorderEndIndex - 1, inorderIndexMap,
                inorderIndex + 1, inorderEndIndex);
        root.left = helper(postorder, postorderStartIndex, postorderStartIndex + nodesLeft - 1, inorderIndexMap,
                inorderStartIndex, inorderIndex - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{4, 2, 5, 1, 3, 6};
        int[] postorder = new int[]{4, 5, 2, 6, 3, 1};
        TreeUtils.printTree(construct(inorder, postorder));
        TreeUtils.printTree(efficientMethod(inorder, postorder));

    }
}
