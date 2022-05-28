import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/***
 * using the fact the topsort only works for directed acyclic graphs, if there is a cycle then topsort fails
 */
public class CycleDirectedBFSKahnsAlgo {

    public static boolean isCycle(List<List<Integer>> adj) {
        int N = adj.size();
        int[] inDegree = new int[N];
        for (List<Integer> node : adj) {
            for (int neighbor : node) {
                inDegree[neighbor]++;
            }
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        int cnt = 0; // counter to check whether we processed all nodes are not, if no cycle then topsort works and all nodes will be processed
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            cnt++;
            for (int neighbor : adj.get(cur)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) queue.offer(neighbor);
            }
            if (cnt == N) return false;
        }
        return true;
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
