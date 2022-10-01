package BinaryTree.Traversals;

import BinaryTree.TreeNode;

import java.util.*;

public class Postorder {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private static void dfs(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        dfs(root.left, result);
        dfs(root.right, result);
        result.add(root.val);
    }

    public static List<Integer> stackTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        //just push root,then right and then left
        // just reverse this order, and we end up with postorderTraversal
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            result.add(curNode.val);
            if (curNode.left != null)
                stack.push(curNode.left);
            if (curNode.right != null)
                stack.push(curNode.right);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(postorderTraversal(root));
        System.out.println(stackTraversal(root));
    }
}
