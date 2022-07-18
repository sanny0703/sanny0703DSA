package Graph;

import java.util.*;

/**
 * Given a reference of a node in a connected undirected graph.
 * <p>
 * Return a deep copy (clone) of the graph.
 * <p>
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 * <p>
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 */
public class CloneGraph {

    public static Node cloneDfs(Node node) {
        if (node == null)
            return null;
        Map<Node, Node> visited = new HashMap<>();
        dfs(node, new Node(node.val), visited);
        return visited.get(node);
    }

    public static void dfs(Node node, Node copy, Map<Node, Node> visited) {
        visited.put(node, copy);
        for (Node neighbor : node.neighbors) {
            if (!visited.containsKey(neighbor))
                dfs(neighbor, new Node(neighbor.val), visited);
            visited.get(node).neighbors.add(visited.get(neighbor));
        }
    }

    public static Node cloneBfs(Node node) {
        if (node == null)
            return null;
        Map<Node, Node> visited = new HashMap<>();
        visited.put(node, new Node(node.val));
        Queue<Node> queue = new ArrayDeque<>();
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                visited.get(cur).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }
}
