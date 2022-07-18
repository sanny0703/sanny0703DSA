package minimumSpannigTrees;

import java.util.*;

/**
 * <h3>Spanning Tree</h3>
 * <i>
 * A minimum spanning tree or minimum weight spanning tree is a subset of the edges of a connected,
 * edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible
 * total edge weight.
 * </i>
 * <br>
 * <br>
 * find the minimum Spanning Tree Using Prim's Algorithm
 * similar to Dijkstras instead of storing min Distance here store the min edge used to connect the previous node to
 * current node
 */
public class PrimsAlgo {
    public static Pair[] minSpanningTree(List<List<Pair>> adj) {
        int N = adj.size();
        int[] minEdgeWeights = new int[N]; // to store minimum possible edge for a node
        Arrays.fill(minEdgeWeights, Integer.MAX_VALUE);
        minEdgeWeights[0] = 0;
        Pair[] prev = new Pair[N];
        prev[0] = new Pair(0, -1);
        boolean[] visited = new boolean[N];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{0, minEdgeWeights[0]});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            visited[node] = true;
            for (Pair neighbor : adj.get(node)) {
                if (!visited[neighbor.node] && minEdgeWeights[neighbor.node] > neighbor.weight) {
                    minEdgeWeights[neighbor.node] = neighbor.weight;
                    prev[neighbor.node] = new Pair(node, minEdgeWeights[neighbor.node]);
                    queue.offer(new int[]{neighbor.node, minEdgeWeights[neighbor.node]});
                }
            }

        }
        return prev;

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
        System.out.println(Arrays.toString(minSpanningTree(adj)));
    }

    public static class Pair {
        int node, weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + node + "," + weight + ")";
        }
    }
}
