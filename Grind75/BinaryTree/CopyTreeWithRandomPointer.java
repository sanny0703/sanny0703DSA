package BinaryTree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * A binary tree is given such that each node contains an additional random pointer which could point to any node in the tree or null.
 * <p>
 * Return a deep copy of the tree.
 * <p>
 * The tree is represented in the same input/output way as normal binary trees where each node is represented as a pair of [val, random_index] where:
 * <p>
 * val: an integer representing Node.val
 * random_index: the index of the node (in the input) where the random pointer points to, or null if it does not point to any node.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [[1,null],null,[4,3],[7,0]]
 * Output: [[1,null],null,[4,3],[7,0]]
 * Explanation: The original binary tree is [1,null,4,7].
 * The random pointer of node one is null, so it is represented as [1, null].
 * The random pointer of node 4 is node 7, so it is represented as [4, 3] where 3 is the index of node 7 in the array representing the tree.
 * The random pointer of node 7 is node 1, so it is represented as [7, 0] where 0 is the index of node 1 in the array representing the tree.
 */

public class CopyTreeWithRandomPointer {
    public static Node copyTree(Node root) {
        if (root == null) return null;
        Map<Node, Node> map = new HashMap<>();
        map.put(root, new Node(root.val));
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.random != null) {
                if (!map.containsKey(currentNode.random)) map.put(currentNode.random, new Node(currentNode.random.val));
                map.get(currentNode).random = map.get(currentNode.random);
            } if (currentNode.left != null) {
                if (!map.containsKey(currentNode.left)) map.put(currentNode.left, new Node(currentNode.left.val));
                map.get(currentNode).left = map.get(currentNode.left);
                queue.offer(currentNode.left);
            } if (currentNode.right != null) {
                if (!map.containsKey(currentNode.right)) map.put(currentNode.right, new Node(currentNode.right.val));
                map.get(currentNode).right = map.get(currentNode.right);
                queue.offer(currentNode.right);
            }
        } return map.get(root);
    }

    public static Node copyDfs(Node root) {
        Map<Node, Node> dfsMap = new HashMap<>();
        if (root == null) return null;
        dfs(root, dfsMap);
        return dfsMap.get(root);
    }

    public static Node dfs(Node root, Map<Node, Node> map) {
        if (root == null) return null;
        if (map.containsKey(root)) return map.get(root);
        Node copy = new Node(root.val);
        copy.left = dfs(root.left, map);
        copy.right = dfs(root.right, map);
        copy.random = dfs(root.random, map);
        return copy;
    }

    static class Node {
        int val;
        Node left, right, random;

        public Node(int val) {
            this.val = val;
        }
    }

}
