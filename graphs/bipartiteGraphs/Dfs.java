package bipartiteGraphs;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Bipartite Graph</h3>
 * <i>
 * A Bipartite Graph is a graph whose vertices can be divided into two independent sets,
 * U and V such that every edge (u, v) either connects a vertex from U to V or a vertex from V to U.
 * In other words, for every edge (u, v), either u belongs to U and v to V, or u belongs to V and v to U.
 * We can also say that there is no edge that connects vertices of same set.
 * </i>
 * <br>
 * <br>
 * find whether a given  graph is bipartite or not
 */
public class Dfs {
    /**
     * try to fill adjacent nodes with two different colors,if two adjacent nodes has same color then the graph
     * is not bipartite
     */
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
