package Graph;

/**
 * Given an m x n 2D binary  grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 */
public class NumberOfIslands {

    public static int count(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int noOfIslands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, n, m, grid);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }

    public static void dfs(int x, int y, int n, int m, char[][] grid) {
        grid[x][y] = '0';
        if (x > 0 && grid[x - 1][y] == '1') dfs(x - 1, y, n, m, grid);
        if (x < n - 1 && grid[x + 1][y] == '1') dfs(x + 1, y, n, m, grid);
        if (y > 0 && grid[x][y - 1] == '1') dfs(x, y - 1, n, m, grid);
        if (y < m - 1 && grid[x][y + 1] == '1') dfs(x, y + 1, n, m, grid);

    }
}
