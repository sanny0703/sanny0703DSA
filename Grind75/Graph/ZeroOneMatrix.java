package Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * iven an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * <p>
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 */
public class ZeroOneMatrix {
    // TC: O(MN)
    public static int[][] solve(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dist = new int[n][m];
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE - 1000);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            if (x > 0 && dist[x - 1][y] > dist[x][y] + 1) {
                dist[x - 1][y] = dist[x][y] + 1;
                queue.offer(new int[]{x - 1, y});
            }
            if (x < n - 1 && dist[x + 1][y] > dist[x][y] + 1) {
                dist[x + 1][y] = dist[x][y] + 1;
                queue.offer(new int[]{x + 1, y});
            }
            if (y > 0 && dist[x][y - 1] > dist[x][y] + 1) {
                dist[x][y - 1] = dist[x][y] + 1;
                queue.offer(new int[]{x, y - 1});
            }
            if (y < m - 1 && dist[x][y + 1] > dist[x][y] + 1) {
                dist[x][y + 1] = dist[x][y] + 1;
                queue.offer(new int[]{x, y + 1});
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solve(new int[][]{
                {0, 0, 0,},
                {0, 1, 0},
                {0, 0, 0}
        })));
    }

}
