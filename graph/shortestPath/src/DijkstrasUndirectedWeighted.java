import java.util.*;

public class DijkstrasUndirectedWeighted {

    public static int[] shortestPath(List<List<Pair>> adj, int src) {
        int N = adj.size();
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        // dist here is the dist from source not the edge weight
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        minHeap.offer(new Pair(src, dist[src]));
        while (!minHeap.isEmpty()) {
            Pair curNode = minHeap.poll();
            for (Pair neighbor : adj.get(curNode.node)) {
                if (dist[neighbor.node] > dist[curNode.node] + neighbor.dist) {
                    dist[neighbor.node] = dist[curNode.node] + neighbor.dist;
                    minHeap.offer(new Pair(neighbor.node, dist[neighbor.node]));
                }
            }
        }
        return dist;
    }

    public static void addEdge(int u, int v, int dist, List<List<Pair>> adj) {
        adj.get(u).add(new Pair(v, dist));
        adj.get(v).add(new Pair(u, dist));
    }

    private static class Pair {
        int node, dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) adj.add(new ArrayList<>());
        addEdge(1, 2, 2, adj);
        addEdge(1, 4, 1, adj);
        addEdge(2, 5, 5, adj);
        addEdge(2, 3, 4, adj);
        addEdge(3, 5, 1, adj);
        addEdge(3, 4, 3, adj);
        System.out.println(Arrays.toString(shortestPath(adj, 1)));
    }
}