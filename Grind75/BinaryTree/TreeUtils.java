package BinaryTree;

public class TreeUtils {
    public static void printTree(TreeNode root){
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.val + "   ");
        printTree(root.right);
    }
}
