package Graph;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a matrix of integers A with R rows and C columns, find the maximum score of a path starting at [0,0] and ending at [R-1,C-1].
 * <p>
 * The score of a path is the minimum value in that path. For example, the value of the path 8 → 4 → 5 → 9 is 4.
 * <p>
 * A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south).
 * <p>
 * <p>
 * Input: [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
 * Output: 3
 */
public class PathWithMaximumMinimumValue {
    private static final int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static int maxMin(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        // take the max path always
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        int res = grid[0][0];
        visited[0][0] = true;
        maxHeap.offer(new int[]{0, 0, grid[0][0]});
        while (!maxHeap.isEmpty()) {
            int[] cur = maxHeap.poll();
            //choose the min of encountered values always
            res = Math.min(res, cur[2]);
            if (cur[0] == n - 1 && cur[1] == m - 1) return res;
            for (int[] dir : directions) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
                    visited[x][y] = true;
                    maxHeap.offer(new int[]{x, y, grid[x][y]});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxMin(new int[][]{{3, 4, 6, 3, 4}, {0, 2, 1, 1, 7}, {8, 8, 3, 2, 7}, {3, 2, 4, 9, 8}, {4, 1, 2, 0, 0}, {4, 6, 5, 4, 3}}));
    }
}
