package DisjointSet;

/**
 * Given a boolean 2D matrix, find the number of islands.
 * Notice
 * 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in same island. We only consider up/down/left/right adjacent.
 * Example
 * Given graph:
 * [
 * [1, 1, 0, 0, 0],
 * [0, 1, 0, 0, 1],
 * [0, 0, 0, 1, 1],
 * [0, 0, 0, 0, 0],
 * [0, 0, 0, 0, 1]
 * ]
 * return 3.
 */
public class NumberOfIslands {
    public static int islands(int[][] grid) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int n = grid.length, m = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int[] direction : directions) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1) {
                            int id1 = n * i + j;
                            int id2 = n * x + y;
                            unionFind.union(id1, id2);
                        }
                    }
                }
            }
        }
        return unionFind.count;
    }

    public static void main(String[] args) {
        System.out.println(islands(new int[][]{{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1}}));
    }

    static class UnionFind {
        int[] root;
        int[] rank;
        int count;

        public UnionFind(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            root = new int[n * m];
            rank = new int[n * m];
            count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int id = n * i + j;
                    if (grid[i][j] == 1) {
                        count++;
                        root[id] = id;
                    }
                    rank[id] = 1;
                }
            }
        }

        public int find(int x) {
            if (x == root[x])
                return x;
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                count--;
                if (rank[rootX] > rank[rootY])
                    root[rootY] = rootX;
                else if (rank[rootY] > rank[rootX])
                    root[rootX] = rootY;
                else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
}
