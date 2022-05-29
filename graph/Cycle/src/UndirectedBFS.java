import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class UndirectedBFS {

    public static boolean isCycle(List<List<Integer>> adj) {
        int N = adj.size();
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (bfs(i, -1, adj, visited)) return true;
            }
        }
        return false;

    }

    public static boolean bfs(int cur, int prev, List<List<Integer>> adj, boolean[] visited) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(cur, prev));
        visited[cur] = true;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (int neighbor : adj.get(curNode.cur)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new Node(neighbor, curNode.cur));
                } else if (neighbor != curNode.prev) return true;
            }
        }
        return false;
    }

    public static void addEdge(int u, int v, List<List<Integer>> adj) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    private static class Node {
        int cur, prev;

        public Node(int cur, int prev) {
            this.cur = cur;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 9; i++) adj.add(new ArrayList<>());
        // first component
        addEdge(1, 3, adj);
        addEdge(3, 4, adj);

        // second component
        addEdge(2, 5, adj);
        addEdge(5, 8, adj);
        addEdge(5, 6, adj);
        addEdge(7, 8, adj);
        addEdge(7, 6, adj);

        System.out.println(isCycle(adj));

    }
}
