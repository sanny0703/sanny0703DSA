package BinaryTree;

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

}
