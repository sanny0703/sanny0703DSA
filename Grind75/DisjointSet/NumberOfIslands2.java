package DisjointSet;

import java.util.ArrayList;
import java.util.List;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land.
 * Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * <p>
 * Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
 * <p>
 * Output: [1,1,2,3]
 * <p>
 * Explanation:
 * <p>
 * Initially, the 2d  grid is filled with water. (Assume 0 represents water and 1 represents land).
 * <p>
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * <p>
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 * <p>
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 * <p>
 * 1 1 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 * <p>
 * 1 1 0
 * 0 0 1   Number of islands = 2
 * 0 0 0
 * <p>
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 * <p>
 * 1 1 0
 * 0 0 1   Number of islands = 3
 * 0 1 0
 * <p>
 * Follow up:
 * <p>
 * Can you do it in time complexity O(k log mn), where k is the length of the positions?
 */
public class NumberOfIslands2 {
    public static List<Integer> islands(int n, int m, int[][] positions) {
        UnionFind unionFind = new UnionFind(n * m);
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        List<Integer> res = new ArrayList<>();
        for (int[] position : positions) {
            int id = n * position[0] + position[1];
            unionFind.setRoot(id);
            for (int[] direction : directions) {
                int x = position[0] + direction[0];
                int y = position[1] + direction[1];
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    int id2 = n * x + y;
                    if (unionFind.isValid(id2)) {
                        unionFind.union(id, id2);
                    }
                }
            }
            res.add(unionFind.count);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(islands(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}}));
    }

    static class UnionFind {
        int count;
        private int[] root;
        private int[] rank;

        public UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            count = 0;
            for (int i = 0; i < n; i++) {
                root[i] = -1;
                rank[i] = 1;
            }
        }

        public boolean isValid(int x) {
            return root[x] >= 0;
        }

        public void setRoot(int x) {
            root[x] = x;
            count++;
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
