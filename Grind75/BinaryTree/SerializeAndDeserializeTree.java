package BinaryTree;

import java.util.*;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <br>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 */
public class SerializeAndDeserializeTree {
    public static String serialize(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<String> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur == null) list.add("#");
            else {
                list.add("" + cur.val);
                stack.push(cur.right);
                stack.push(cur.left);

            }
        }
        return String.join(",", list);
    }

    static int nodeIndex;

    public static TreeNode deserialize(String data) {
        if (data == null)
            return null;
        nodeIndex = 0;
        return treeBuilder(data.split(","));
    }

    public static TreeNode treeBuilder(String[] nodes) {
        if (nodes[nodeIndex].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[nodeIndex]));
        nodeIndex++;
        root.left = treeBuilder(nodes);
        nodeIndex++;
        root.right = treeBuilder(nodes);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        TreeUtils.printTree(root);
        System.out.println();
        String data = serialize(root);
        root = deserialize(data);
        TreeUtils.printTree(root);
        System.out.println();
    }
}
