package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 * <p>
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 * <p>
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 * <p>
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 * <p>
 * <p>
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 */
public class PacificAtlanticWaterFlow {
    public static List<List<Integer>> waterFlow(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        boolean[][] pacific = new boolean[n][m]; // represents the cells that can flow to pacific
        boolean[][] atlantic = new boolean[n][m]; // represents the cells that can flow to atlantic
        /**
         * North and East is pacific
         * South and West is atlantic
         *
         * Now First row (i=0) and first column(j=0) can flow to pacific ,since they are at coast
         * starting from these cells, all those cells which the dfs can reach can flow to pacific
         *
         *similarly, last row(i=n-1) and last column(j=m-1) can flow to atlantic since they are at coast
         * starting from these cells, all those cells which the dfs can reach can flow to atlantic
         */
        for (int i = 0; i < n; i++) {
            dfs(i, 0, n, m, heights, pacific, -1); // staring from first column for pacific flow cells
            dfs(i, m - 1, n, m, heights, atlantic, -1); // starting from last column for atlantic flow cells
        }
        for (int j = 0; j < m; j++) {
            dfs(0, j, n, m, heights, pacific, -1); // staring from first row for pacific
            dfs(n - 1, j, n, m, heights, atlantic, -1); // starting from last row for atlantic
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (atlantic[i][j] && pacific[i][j]) ans.add(Arrays.asList(i, j));
            }
        }
        return ans;
    }

    public static void dfs(int x, int y, int n, int m, int[][] heights, boolean[][] visited, int prev) {
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || heights[x][y] < prev) return;
        visited[x][y] = true;
        dfs(x - 1, y, n, m, heights, visited, heights[x][y]);
        dfs(x + 1, y, n, m, heights, visited, heights[x][y]);
        dfs(x, y - 1, n, m, heights, visited, heights[x][y]);
        dfs(x, y + 1, n, m, heights, visited, heights[x][y]);
    }

    public static void main(String[] args) {
        System.out.println(waterFlow(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}));
    }
}
