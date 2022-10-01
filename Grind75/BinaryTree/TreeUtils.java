package BinaryTree;

public class TreeUtils {
    public static void printTree(TreeNode root) {
        print(root);
        System.out.println();
    }

    private static void print(TreeNode root) {
        if (root == null) return;
        print(root.left);
        System.out.print(root.val + "   ");
        print(root.right);
    }
}
