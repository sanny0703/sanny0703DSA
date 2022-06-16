package shortestPath.undirected;

import java.util.*;

/**
 * shortest path in undirected unweighted graph
 */
public class UnitEdgeWeights {
    public static List<Integer> shortestPath(List<List<Integer>> adj, int src, int dest) {
        int N = adj.size();
        int[] prev = new int[N];
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        prev[src] = -1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(src);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neighbor : adj.get(cur)) {
                if (dist[neighbor] > dist[cur] + 1) {
                    dist[neighbor] = dist[cur] + 1;
                    prev[neighbor] = cur;
                    queue.offer(neighbor);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (dist[dest] == Integer.MAX_VALUE) return ans;
        ans.add(dest);
        int index = dest;
        while (prev[index] != -1) {
            ans.add(prev[index]);
            index = prev[index];
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void addEdge(int u, int v, List<List<Integer>> adj) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(0, 1, adj);
        addEdge(0, 3, adj);
        addEdge(1, 3, adj);
        addEdge(1, 2, adj);
        addEdge(2, 6, adj);
        addEdge(3, 4, adj);
        addEdge(4, 5, adj);
        addEdge(5, 6, adj);
        addEdge(6, 7, adj);
        addEdge(6, 8, adj);
        addEdge(7, 8, adj);
        //3
        System.out.println(shortestPath(adj, 0, 5));
    }
}
