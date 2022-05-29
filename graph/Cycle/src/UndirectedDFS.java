import java.util.ArrayList;
import java.util.List;

public class UndirectedDFS {

    public static boolean isCycle(List<List<Integer>> adj) {
        int N = adj.size();
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, visited)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(int cur, int prev, List<List<Integer>> adj, boolean[] visited) {
        visited[cur] = true;
        for (int neighbor : adj.get(cur)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, cur, adj, visited)) return true;
            } else if (prev != neighbor) return true;
        }
        return false;
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

        System.out.println(isCycle(adj));

    }
}
