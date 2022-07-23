package DynamicProgramming;

import java.util.Arrays;

/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 * Note: You can only put the bomb at an empty cell.
 * <p>
 * <p>
 * Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
 * Output: 3
 * Explanation: For the given grid,
 * <p>
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 * <p>
 * Placing a bomb at (1,1) kills 3 enemies.
 */
public class BombEnemy {
    private static int enemyCount;

    public static int maxKill(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            enemyCount = 0;
            for (int j = 0; j < m; j++) {
                update(i, j, grid, dp);
            }
            enemyCount = 0;
            for (int j = m - 1; j >= 0; j--)
                update(i, j, grid, dp);
        }
        for (int j = 0; j < m; j++) {
            enemyCount = 0;
            for (int i = 0; i < n; i++)
                update(i, j, grid, dp);
            enemyCount = 0;
            for (int i = n - 1; i >= 0; i--)
                update(i, j, grid, dp);
        }
        int res = 0;
        for (int[] row : dp)
            res = Math.max(res, Arrays.stream(row).max().getAsInt());
        return res;
    }

    public static void update(int i, int j, char[][] grid, int[][] dp) {
        if (grid[i][j] == '0') dp[i][j] += enemyCount;
        else if (grid[i][j] == 'E') enemyCount++;
        else enemyCount = 0;
    }

    public static void main(String[] args) {
        System.out.println(maxKill(new char[][]{{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}}));
    }
}
