package minimumSpannigTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Find the Minimum Spanning Tree Using Kruskal's Algorithm
 * <br>
 * <br>
 * here we first sort all the edges in ascending order of the edge weights, we only edges to our edge list
 * only when adding that particular edge is not previously added and adding it doesn't form any cycle
 */
public class KruskalsAlgo {
    public static Pair[] minSpanningTree(List<Tuple> adj, int N) {
        adj.sort(Comparator.comparing(a -> a.weight));
        Pair[] prev = new Pair[N];
        prev[0] = new Pair(0, -1);
        UnionFind uf = new UnionFind(N);
        for (Tuple edge : adj) {
            int u = edge.u, v = edge.v, weight = edge.weight;
            if (!uf.connected(u, v)) {
                uf.union(u, v);
                prev[v] = new Pair(u, weight);
            }
        }
        return prev;
    }

    static class Tuple {
        int weight, u, v;

        public Tuple(int weight, int u, int v) {
            this.weight = weight;
            this.u = u;
            this.v = v;
        }

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

        List<Tuple> adj = new ArrayList<>();
        adj.add(new Tuple(2, 0, 1));
        adj.add(new Tuple(6, 0, 3));
        adj.add(new Tuple(3, 1, 2));
        adj.add(new Tuple(8, 1, 3));
        adj.add(new Tuple(5, 1, 4));
        adj.add(new Tuple(7, 2, 4));
        System.out.println(Arrays.toString(minSpanningTree(adj, 5)));
    }

}
