import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/***
 * make use of topSort here
 */
public class WeightedDAG {

    public static int[] shortestPath(List<List<Pair>> adj, int src) {
        int N = adj.size();
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Stack<Integer> stack = topSort(adj);
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (Pair neighbor : adj.get(cur)) {
                dist[neighbor.node] = Math.min(dist[neighbor.node], dist[cur] + neighbor.dist);
            }
        }
        return dist;
    }

    public static Stack<Integer> topSort(List<List<Pair>> adj) {
        Stack<Integer> ans = new Stack<>();
        int N = adj.size();
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) dfs(i, adj, visited, ans);
        }
        return ans;
    }

    public static void dfs(int cur, List<List<Pair>> adj, boolean[] visited, Stack<Integer> ans) {
        visited[cur] = true;
        for (Pair neighbor : adj.get(cur)) {
            if (!visited[neighbor.node]) dfs(neighbor.node, adj, visited, ans);
        }
        ans.push(cur);
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
        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(4, 1));
        adj.get(1).add(new Pair(2, 3));
        adj.get(2).add(new Pair(3, 6));
        adj.get(4).add(new Pair(2, 2));
        adj.get(4).add(new Pair(5, 4));
        adj.get(5).add(new Pair(3, 1));
        System.out.println(Arrays.toString(shortestPath(adj, 0)));
    }
}
