package topologicalOrder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * topological ordering using bfs(Kahn's algo)
 */
public class BfsKahnSAlgo {
    public static List<Integer> topOrder(List<List<Integer>> adj) {
        int N = adj.size();
        int[] inDegree = new int[N];
        for (List<Integer> neighbors : adj) {
            for (int neighbor : neighbors) {
                inDegree[neighbor]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans.add(cur);
            for (int neighbor : adj.get(cur)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);
        System.out.println(topOrder(adj));
    }
}
