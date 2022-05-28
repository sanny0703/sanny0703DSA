import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalsAlgo {

    public static List<Node> spanningTree(List<List<Pair>> adj) {
        int N = adj.size();
        List<Node> edges = new ArrayList<>();
        List<Node> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (Pair neighbor : adj.get(i)) {
                edges.add(new Node(neighbor.dist, i, neighbor.node));
            }
        }
        edges.sort(Comparator.comparingInt(a -> a.dist));
        boolean[] visited = new boolean[N];
        for (Node node : edges) {
            if (!visited[node.u] || !visited[node.v]) {
                ans.add(node);
                visited[node.u] = visited[node.v] = true;
            }
        }
        return ans;
    }

    private static class Pair {
        int node, dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    private static class Node {
        int dist, u, v;

        public Node(int dist, int u, int v) {
            this.dist = dist;
            this.u = u;
            this.v = v;
        }

        @Override
        public String toString() {
            return "(" + dist + ",u:" + u + ",v:" + v + ")";
        }
    }

    public static void addEdge(int u, int v, int dist, List<List<Pair>> adj) {
        adj.get(u).add(new Pair(v, dist));
        adj.get(v).add(new Pair(u, dist));
    }

    public static void main(String[] args) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < 7; i++) adj.add(new ArrayList<>());
        addEdge(1, 2, 2, adj);
        addEdge(1, 4, 1, adj);
        addEdge(1, 5, 4, adj);
        addEdge(2, 3, 3, adj);
        addEdge(2, 3, 4, adj);
        addEdge(2, 6, 7, adj);
        addEdge(3, 4, 5, adj);
        addEdge(3, 6, 8, adj);
        addEdge(4, 5, 9, adj);
        System.out.println(spanningTree(adj));
    }
}
