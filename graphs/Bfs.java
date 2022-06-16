import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Breadth First Traversal Of a graph
 * here siblings are visited  before children
 */
public class Bfs {
    public static List<Integer> traverse(List<List<Integer>> adj) {
        int N = adj.size();
        boolean[] visited = new boolean[N];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!visited[i])
                bfs(i, adj, visited, ans);
        }
        return ans;
    }

    public static void bfs(int cur, List<List<Integer>> adj, boolean[] visited, List<Integer> ans) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(cur);
        visited[cur] = true;
        ans.add(cur);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int neighbor : adj.get(temp)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    ans.add(neighbor);
                }
            }

        }
    }

    public static void addEdge(int u, int v, List<List<Integer>> adj) {
        adj.get(u).add(v);
        adj.get(v).add(u);
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

        System.out.println(traverse(adj));
    }
}
