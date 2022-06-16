package bipartiteGraphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * find whether a graph is bipartite or not by using BFS algo
 */
public class Bfs {
    public static boolean isBipartite(List<List<Integer>> adj) {
        int N = adj.size();
        int[] color = new int[N];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        color[0] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neighbor : adj.get(cur)) {
                if (color[neighbor] == 0) {
                    color[neighbor] = color[cur] == 1 ? 2 : 1;
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[cur]) return false;
            }
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
