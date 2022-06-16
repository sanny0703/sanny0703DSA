package shortestPath.directed;

import java.util.*;

/**
 * find the shortest Path in a weighted DAG using Dijkstras Algo
 */
public class WeightedDAG {
    public static List<Pair> shortestPath(List<List<Pair>> adj, int src, int dest) {
        int N = adj.size();
        int[] dist = new int[N];
        Pair[] prev = new Pair[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        prev[src] = new Pair(-1, -1);
        dist[src] = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        queue.offer(new Pair(src, 0));
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int curNode = cur.node, curDist = cur.dist;
            if (curNode == dest) break;
            for (Pair neighbor : adj.get(curNode)) {
                if (dist[neighbor.node] > curDist + neighbor.dist) {
                    dist[neighbor.node] = curDist + neighbor.dist;
                    prev[neighbor.node] = new Pair(curNode, neighbor.dist);
                    queue.offer(new Pair(neighbor.node, dist[neighbor.node]));
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
        return ans;

    }

    static class Pair {
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

    public static void main(String[] args) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) adj.add(new ArrayList<>());
        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(4, 1));
        adj.get(1).add(new Pair(2, 3));
        adj.get(2).add(new Pair(3, 6));
        adj.get(4).add(new Pair(2, 2));
        adj.get(4).add(new Pair(5, 4));
        adj.get(5).add(new Pair(3, 1));
        System.out.println(shortestPath(adj, 0, 5));
        System.out.println(shortestPath(adj, 0, 2));
        System.out.println(shortestPath(adj, 0, 3));
    }
}
