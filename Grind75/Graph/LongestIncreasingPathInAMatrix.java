package Graph;

/**
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 * <p>
 * From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 * <p>
 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 */
public class LongestIncreasingPathInAMatrix {
    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int longestPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] cache = new int[n][m];
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dfs(i, j, n, m, matrix, cache));
            }
        }
        return max;
    }

    public static int dfs(int x, int y, int n, int m, int[][] matrix, int[][] cache) {
        if (cache[x][y] != 0) return cache[x][y];
        int max = 1;
        for (int[] d : dir) {
            int newX = x + d[0], newY = y + d[1];
            if (newX < 0 || newX >= n || newY < 0 || newY >= m || matrix[newX][newY] <= matrix[x][y]) continue;
            max = Math.max(max, 1 + dfs(newX, newY, n, m, matrix, cache));
        }
        return cache[x][y] = max;
    }

    public static void main(String[] args) {
        System.out.println(longestPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
    }

}
