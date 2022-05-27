import java.util.ArrayList;
import java.util.List;

public class BipartiteDFS {

    public static boolean isBipartite(List<List<Integer>> adj) {
        int N = adj.size();
        int[] color = new int[N];
        return dfs(0, -1, adj, color);

    }

    public static boolean dfs(int cur, int prev, List<List<Integer>> adj, int[] color) {
        color[cur] = prev == -1 ? 1 : color[prev] == 1 ? 2 : 1;
        for (int neighbor : adj.get(cur)) {
            if (color[neighbor] == 0) {
                if (!dfs(neighbor, cur, adj, color)) return false;

            } else if (color[neighbor] == color[cur]) return false;
        }
        return true;
    }

    public static void addEdge(int u, int v, List<List<Integer>> adj) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(0, 1, adj);
        addEdge(2, 1, adj);
        addEdge(2, 3, adj);
        addEdge(4, 3, adj);
        addEdge(4, 5, adj);
        addEdge(4, 6, adj);
        addEdge(6, 1, adj);
        System.out.println(isBipartite(adj));
    }
}
