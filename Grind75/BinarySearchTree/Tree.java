package BinarySearchTree;

/**
 * Binary search tree basic operations
 */
public class Tree {
    public static TreeNode insertNode(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) root.right = insertNode(root.right, val);
        if (root.val > val) root.left = insertNode(root.left, val);
        return root;
    }

    public static TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val > val) root.left = deleteNode(root.left, val);
        else if (root.val < val) root.right = deleteNode(root.right, val);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            int minValue = inorderSuccessor(root.right);
            root.right = deleteNode(root.right, minValue);
        }
        return root;
    }

    public static int inorderSuccessor(TreeNode root) {
        int minKey = 0;
        while (root != null) {
            minKey = root.val;
            root = root.left;
        }
        return minKey;
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.val + "   ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        printTree(root);
        System.out.println();
        root = insertNode(root, 3);
        root = insertNode(root, 6);
        root = insertNode(root, 2);
        printTree(root);
        System.out.println();
        deleteNode(root, 2);
        printTree(root);
        System.out.println();
    }
}
