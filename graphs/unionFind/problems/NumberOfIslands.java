package unionFind.problems;

/**
 * Given an m x n 2D binary grid, grid which represents a map of '1's (land) and '0's (water), return the number of
 * islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may
 * assume all four edges of the grid are all surrounded by water.
 * <p>
 * <code>
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * <p>
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 * </code>
 */
public class NumberOfIslands {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static int islandsCount(char[][] grid) {
        UnionFind uf = new UnionFind(grid);
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    for (int[] direction : DIRECTIONS) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (x > 0 && x < n && y > 0 && y < m && grid[x][y] == '1') {
                            int id1 = i * m + j;
                            int id2 = x * m + y;
                            uf.connect(id1, id2);
                        }
                    }
                }
            }
        }
        return uf.count;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        //3
        System.out.println(islandsCount(grid));
    }

    private static class UnionFind {
        int[] root;
        int[] rank;
        int count;

        public UnionFind(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            root = new int[n * m];
            rank = new int[n * m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1') {
                        int id = i * m + j;
                        root[id] = id;
                        rank[id] = 1;
                        count++;
                    }
                }
            }
        }

        public int find(int x) {
            if (x == root[x]) return x;
            return root[x] = find(root[x]);
        }

        public void connect(int x, int y) {
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
            count--;
        }
    }

}
