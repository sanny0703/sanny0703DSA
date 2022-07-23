package BinaryTree;

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
}
