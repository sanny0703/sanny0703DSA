import java.util.*;

public class PrimsAlgo {

    public static Pair[] spanningTree(List<List<Pair>> adj) {
        int N = adj.size();
        Pair[] parent = new Pair[N];
        parent[0] = new Pair(0, -1);
        int[] keys = new int[N];
        Arrays.fill(keys, Integer.MAX_VALUE);
        keys[0] = 0;
        boolean[] visited = new boolean[N];
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        minHeap.offer(new Pair(0, keys[0]));
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            visited[cur.node] = true;
            for (Pair neighbor : adj.get(cur.node)) {
                if (!visited[neighbor.node] && neighbor.dist < keys[neighbor.node]) {
                    keys[neighbor.node] = neighbor.dist;
                    parent[neighbor.node] = new Pair(cur.node, keys[neighbor.node]);
                    minHeap.offer(new Pair(neighbor.node, keys[neighbor.node]));
                }
            }
        }
        return parent;
    }

    private static class Pair {
        int node, dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "(" + node + "," + dist + ")";
        }
    }

    public static void addEdge(int u, int v, int dist, List<List<Pair>> adj) {
        adj.get(u).add(new Pair(v, dist));
        adj.get(v).add(new Pair(u, dist));
    }

    public static void main(String[] args) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) adj.add(new ArrayList<>());
        addEdge(0, 1, 2, adj);
        addEdge(0, 3, 6, adj);
        addEdge(1, 2, 3, adj);
        addEdge(1, 3, 8, adj);
        addEdge(1, 4, 5, adj);
        addEdge(2, 4, 7, adj);
        System.out.println(Arrays.toString(spanningTree(adj)));
    }
}
