package DisjointSet.unionFind;

public class QuickFind {
    private int[] root;

    public QuickFind(int n) {
        root = new int[n];
        for (int i = 0; i < n; i++)
            root[i] = i;
    }

    public int find(int x) {
        return root[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootY)
                    root[i] = rootX;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
    /**
     * TC:
     * find : O(1), union: O(N), connected: O(N), constructor:O(N)
     */
}
