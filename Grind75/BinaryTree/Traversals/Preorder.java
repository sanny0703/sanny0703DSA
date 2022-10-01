package BinaryTree.Traversals;

import BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Preorder {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private static void dfs(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        result.add(root.val);
        dfs(root.left, result);
        dfs(root.right, result);
    }

    public static List<Integer> stackTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            result.add(curNode.val);
            //just push right child first to make sure left child will be the first to be visited
            if (curNode.right != null)
                stack.push(curNode.right);
            if (curNode.left != null)
                stack.push(curNode.left);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(preorderTraversal(root));
        System.out.println(stackTraversal(root));
    }
}
