package BinaryTree.Traversals;

import BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Inorder {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private static void dfs(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        dfs(root.left, result);
        result.add(root.val);
        dfs(root.right, result);
    }

    public static List<Integer> stackTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        // just got to left as down as possible
        // pop from stack and if it has right child add it, otherwise move up
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(inorderTraversal(root));
        System.out.println(stackTraversal(root));
    }
}
