package unionFind;

/**
 * optimised version of UnionFind algorithm by rank and path compression
 */
public class UnionFind {
    int[] root;
    int[] rank;

    public UnionFind(int n) {
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    /**
     * Path Compression
     * <p>
     * To avoid finding root again and again ,we just replace the representative of that particular set in only one
     * call, so all the subsequent calls to find are returned in constant time
     */
    public int find(int a) {
        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }

    /**
     * Union By Size:
     * <p>
     * Remember when we called combine(u,v) we always make u as the representative of v, however we could have done
     * opposite as well.We can reduce the tree height by comparing the size of sets we are going to combine and always
     * make the bigger set as the representative of the smaller.
     */
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
                rank[rootX] += rank[rootY];
            } else {
                root[rootX] = rootY;
                rank[rootY] += rank[rootX];
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
