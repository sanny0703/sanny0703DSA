package BinaryTree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <br>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 */
public class SerializeAndDeserializeTree {
    private static final String SPLITTER = "#";
    private static final String NULL = "X";

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private static void preorder(TreeNode root, StringBuilder sb) {
        if (root == null)
            sb.append(NULL).append(SPLITTER);
        else {
            sb.append(root.val).append(SPLITTER);
            preorder(root.left, sb);
            preorder(root.right, sb);
        }
    }

    public static TreeNode deserialize(String data) {
        Deque<String> queue = new ArrayDeque<>(Arrays.asList(data.split(SPLITTER)));
        return buildTree(queue);
    }

    private static TreeNode buildTree(Deque<String> queue) {
        String val = queue.poll();
        if (val.equals(NULL))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
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
