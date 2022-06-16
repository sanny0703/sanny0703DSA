package shortestPath.directed;

import java.util.*;

/**
 * Find the shortest path in a weighted DAG using topSort
 */
public class UsingTopSort {
    public static List<Pair> shortestPath(List<List<Pair>> adj, int src, int dest) {
        int N = adj.size();
        Pair[] prev = new Pair[N];
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        prev[src] = new Pair(-1, -1);
        Stack<Integer> stack = topSort(adj);
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (cur == dest) break;
            for (Pair neighbor : adj.get(cur)) {
                if (dist[neighbor.node] > dist[cur] + neighbor.weight) {
                    dist[neighbor.node] = dist[cur] + neighbor.weight;
                    prev[neighbor.node] = new Pair(cur, neighbor.weight);

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

    public static Stack<Integer> topSort(List<List<Pair>> adj) {
        int N = adj.size();
        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (!visited[i])
                dfs(i, adj, visited, stack);
        }
        return stack;
    }

    public static void dfs(int cur, List<List<Pair>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[cur] = true;
        for (Pair neighbor : adj.get(cur)) {
            if (!visited[neighbor.node])
                dfs(neighbor.node, adj, visited, stack);
        }
        stack.push(cur);
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
        System.out.println(shortestPath(adj, 0, 3));
    }
}
