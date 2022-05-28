import java.util.*;

public class UndirectedNoEdgeWeightBFS {

    public static int[] shortestDist(List<List<Integer>> adj, int src) {
        int N = adj.size();
        int[] dist = new int[N];
        Arrays.fill(dist, 1000000);
        Deque<Integer> queue = new ArrayDeque<>();
        dist[src] = 0;
        queue.offer(src);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neighbor : adj.get(cur)) {
                if (dist[neighbor] > dist[cur] + 1) {
                    dist[neighbor] = dist[cur] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        return dist;
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
        System.out.println(Arrays.toString(shortestDist(adj, 0)));
    }
}
