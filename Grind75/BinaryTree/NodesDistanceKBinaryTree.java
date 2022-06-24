package BinaryTree;

import java.util.*;

/**
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
 * <br>
 * You can return the answer in any order.
 * <br>
 * <br>
 * <code>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2<br>
 * Output: [7,4,1]<br>
 * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
 * </code>
 */
public class NodesDistanceKBinaryTree {
    /**
     * the idea here is ,if we have access to parent of each node,then we have access to all nodes of distance 1 from a node
     * <br>
     * Use dfs to get parent of each node,the do a bfs for given target node inside the distance k
     */
    public static List<Integer> nodes(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        dfs(root, null, parentMap);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(root);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Integer> ans = new ArrayList<>();
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (dist == k) ans.add(cur.val);
                else if (dist < k) {
                    if (cur.left != null && !visited.contains(cur.left)) {
                        visited.add(cur.left);
                        queue.offer(cur.left);
                    }
                    if (cur.right != null && !visited.contains(cur.right)) {
                        visited.add(cur.right);
                        queue.offer(cur.right);
                    }
                    TreeNode parent = parentMap.get(cur);
                    if (parent != null && !visited.contains(parent)) {
                        visited.add(parent);
                        queue.offer(parent);
                    }
                }
            }
            dist++;
        }
        return ans;
    }

    public static void dfs(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (root != null) {
            parentMap.put(root, parent);
            dfs(root.left, root, parentMap);
            dfs(root.right, root, parentMap);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                new TreeNode(1, new TreeNode(0), new TreeNode(8)));

        System.out.println(nodes(root, root.left, 2));
    }
}
