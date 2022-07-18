package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
 * <p>
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 * <p>
 * 0          3
 * |          |
 * 1 --- 2    4
 * <p>
 * Output: 2
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public static int connectedComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int countComponents = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                countComponents++;
            }
        }
        return countComponents;
    }

    public static void dfs(int cur, List<List<Integer>> adj, boolean[] visited) {
        visited[cur] = true;
        for (int neighbor : adj.get(cur)) {
            if (!visited[neighbor]) dfs(neighbor, adj, visited);
        }
    }

    public static void main(String[] args) {
        System.out.println(connectedComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));
    }
}
