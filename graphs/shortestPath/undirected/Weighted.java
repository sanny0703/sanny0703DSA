package shortestPath.undirected;

import java.util.*;

/**
 * find the shortest path in undirected weighted graph using <b>Dijkstras Algorithm</b>
 */
public class Weighted {
    public static List<Pair> shortestPath(List<List<Pair>> adj, int src, int dest) {
        int N = adj.size();
        Pair[] prev = new Pair[N];
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        prev[src] = new Pair(-1, -1);
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{src, dist[src]});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0], weight = cur[1];
            if (node == dest) break;
            for (Pair neighbor : adj.get(node)) {
                if (dist[neighbor.node] > weight + neighbor.weight) {
                    dist[neighbor.node] = weight + neighbor.weight;
                    prev[neighbor.node] = new Pair(node, neighbor.weight);
                    queue.offer(new int[]{neighbor.node, dist[neighbor.node]});
                }
            }
        }
        List<Pair> ans = new ArrayList<>();
        ans.add(new Pair(dest, -1));
        int index = dest;
        while (prev[index].node != -1) {
            ans.add(prev[index]);
            index = prev[index].node;
        }
        Collections.reverse(ans);
        System.out.println("dist: " + dist[dest]);
        return ans;
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

    public static void addEdge(int u, int v, int weight, List<List<Pair>> adj) {
        adj.get(u).add(new Pair(v, weight));
        adj.get(v).add(new Pair(u, weight));
    }

    public static void main(String[] args) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) adj.add(new ArrayList<>());
        addEdge(0, 1, 2, adj);
        addEdge(0, 2, 4, adj);
        addEdge(1, 5, 5, adj);
        addEdge(2, 3, 2, adj);
        addEdge(3, 4, 1, adj);
        addEdge(4, 5, 3, adj);
        System.out.println(shortestPath(adj, 0, 5));
        System.out.println(shortestPath(adj, 5, 2));
    }
}
