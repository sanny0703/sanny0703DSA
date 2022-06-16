package cycle.directedGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * find if there is a cycle in Directed Graph
 * <p>
 * The idea here is to use topSort, as we know topSort order only exists for DAG, i.e. if we cannot generate a TopSort
 * Order of vertices that means there is a cycle
 */
public class BfsTopSort {
    public static boolean isCycle(List<List<Integer>> adj) {
        int N = adj.size();
        int[] inDegree = new int[N];
        for (List<Integer> neighbors : adj) {
            for (int neighbor : neighbors)
                inDegree[neighbor]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            cnt++;
            for (int neighbor : adj.get(cur)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }
        return cnt != N;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);
        System.out.println(isCycle(adj));
    }
}
