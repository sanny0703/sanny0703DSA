package DisjointSet.unionFind;

public class QuickUnion {
    private int[] root;

    public QuickUnion(int n) {
        root = new int[n];
        for (int i = 0; i < n; i++)
            root[i] = i;
    }

    public int find(int x) {
        while (x != root[x])
            x = root[x];
        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
    /**
     * Tc:
     * find: O(N), union: O(N), connected: O(N), constructor:O(N)
     */
}
