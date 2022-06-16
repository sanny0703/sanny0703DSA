import java.util.ArrayList;
import java.util.List;

/**
 * Depth first Traversal of a graph
 * Goes all the way to depth of a node before going to the other node
 * here children are visited before siblings
 */
public class Dfs {
    public static List<Integer> traverse(List<List<Integer>> adj) {
        int N = adj.size();
        boolean[] visited = new boolean[N];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!visited[i])
                dfs(i, adj, visited, ans);
        }
        return ans;
    }

    public static void dfs(int cur, List<List<Integer>> adj, boolean[] visited, List<Integer> ans) {
        visited[cur] = true;
        for (int neighbor : adj.get(cur)) {
            if (!visited[neighbor])
                dfs(neighbor, adj, visited, ans);
        }
        ans.add(cur);
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
