package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You are starving and you want to eat food as quickly as possible. You want to find the shortest path to arrive at a food cell.
 * <p>
 * You are given an m x n character matrix, grid, of these different types of cells:
 * <p>
 * '*' is your location. There is exactly one '*' cell.
 * '#' is a food cell. There may be multiple food cells.
 * 'O' is free space, and you can travel through these cells.
 * 'X' is an obstacle, and you cannot travel through these cells.
 * Return the length of the shortest path for you to reach any food cell. If there is no path for you to reach food, return -1.
 * <p>
 * Input: grid = [["X","X","X","X","X","X"],["X","*","O","O","O","X"],["X","O","O","#","O","X"],["X","X","X","X","X","X"]]
 * Output: 3
 * Explanation: It takes 3 steps to reach the food.
 */
public class ShortestPathToGetFood {
    public static int shortestPath(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int srcRow = 0, srcColumn = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '*') {
                    srcColumn = j;
                    srcRow = i;
                    break;
                }
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{srcRow, srcColumn});
        visited[srcRow][srcColumn] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[0];
                if (grid[x][y] == '#') return steps;
                if (x > 0 && !visited[x - 1][y] && grid[x - 1][y] != 'X') {
                    visited[x - 1][y] = true;
                    queue.offer(new int[]{x - 1, y});
                }
                if (x < n - 1 && !visited[x + 1][y] && grid[x + 1][y] != 'X') {
                    visited[x + 1][y] = true;
                    queue.offer(new int[]{x + 1, y});
                }
                if (y > 0 && !visited[x][y - 1] && grid[x][y - 1] != 'X') {
                    visited[x][y - 1] = true;
                    queue.offer(new int[]{x, y - 1});
                }
                if (y < m - 1 && !visited[x][y + 1] && grid[x][y + 1] != 'X') {
                    visited[x][y + 1] = true;
                    queue.offer(new int[]{x, y + 1});
                }
            }
            steps++;
        }
        return -1;
    }

}
