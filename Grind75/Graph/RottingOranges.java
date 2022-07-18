package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * <p>
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 * <p>
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 */
public class RottingOranges {
    public static int getTime(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int time = 0, freshOranges = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) freshOranges++;
                else if (grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }
        if (freshOranges == 0) return 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                if (x > 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    queue.offer(new int[]{x - 1, y});
                    freshOranges--;
                }
                if (x < n - 1 && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    queue.offer(new int[]{x + 1, y});
                    freshOranges--;
                }
                if (y > 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    queue.offer(new int[]{x, y - 1});
                    freshOranges--;
                }
                if (y < m - 1 && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    queue.offer(new int[]{x, y + 1});
                    freshOranges--;
                }
            }
            time++;
        }
        return freshOranges == 0 ? time - 1 : -1;

    }

    public static void main(String[] args) {
        System.out.println(getTime(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }
}
