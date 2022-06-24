package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the maximum width of the given tree.
 * <br>
 * The maximum width of a tree is the maximum width among all levels.
 * <br>
 * The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes),
 * where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
 * <br>
 * <br>
 * <code>
 * Input: root = [1,3,2,5,3,null,9]<br>
 * Output: 4<br>
 * Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
 * </code>
 */
public class WidthOfBinaryTree {
    public static int maxWidth(TreeNode root) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 0));
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // maintain left and right index for each level
            int rightMostIndex = 0;
            int leftMostIndex = 0;
            for (int i = 1; i <= size; i++) {
                Pair cur = queue.poll();
                TreeNode node = cur.node;
                int index = cur.index;
                if (i == 1) {
                    leftMostIndex = index; // update left index only for first node
                }
                rightMostIndex = index; // update right index for every new node
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * index + 1)); // the index of left child will be 2*i+1
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * index + 2)); // index of right child will be 2*i+2;
                }
            }
            ans = Math.max(ans, rightMostIndex - leftMostIndex + 1); // taking the maximum
        }
        return ans;
    }

    public static class Pair {
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        System.out.println(maxWidth(root));
    }
}
