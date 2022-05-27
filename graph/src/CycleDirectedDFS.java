import java.util.ArrayList;
import java.util.List;

public class CycleDirectedDFS {

    public static boolean isCycle(List<List<Integer>> adj) {
        int N = adj.size();
        boolean[] visited = new boolean[N];
        boolean[] dfsVisited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, dfsVisited)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(int cur, List<List<Integer>> adj, boolean[] visited, boolean[] dfsVisited) {
        visited[cur] = true;
        dfsVisited[cur] = true;
        for (int neighbor : adj.get(cur)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, dfsVisited)) return true;

            } else if (dfsVisited[neighbor]) return true;
        }
        dfsVisited[cur] = false;
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(6);
        adj.get(4).add(5);
        adj.get(6).add(5);
        adj.get(7).add(2);
        adj.get(7).add(8);
        adj.get(8).add(9);
        adj.get(9).add(7);
        System.out.println(isCycle(adj));
    }
}
