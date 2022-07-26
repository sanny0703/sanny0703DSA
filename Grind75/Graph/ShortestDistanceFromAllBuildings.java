package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * <p>
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * <p>
 * Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * <p>
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * <p>
 * Output: 7
 * <p>
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
 * the point (1,2) is an ideal empty land to build a house, as the total
 * travel distance of 3+3+1=7 is minimal. So return 7.
 */
public class ShortestDistanceFromAllBuildings {
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static int shortestDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (n == 0 || m == 0) return -1;
        int[][] dis = new int[n][m]; // min distance sum to all buildings from i,j
        int[][] numBuildings = new int[n][m]; // total buildings that can be visited from i,j
        int buildingsCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    buildingsCount++;
                    bfs(i, j, dis, numBuildings, grid, n, m);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && dis[i][j] != 0 && numBuildings[i][j] == buildingsCount) {
                    min = Math.min(min, dis[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void bfs(int x, int y, int[][] dis, int[][] numBuildings, int[][] grid, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            while (size-- > 0) {
                int[] cur = queue.poll();
                int X = cur[0], Y = cur[1];
                for (int[] direction : directions) {
                    int newX = X + direction[0];
                    int newY = Y + direction[1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 0 && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        dis[newX][newY] += distance;
                        numBuildings[newX][newY] += 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(shortestDistance(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
    }
}
