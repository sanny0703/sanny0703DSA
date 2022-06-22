package DynamicProgramming;

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). <br>
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 * <br>
 * <br>
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * <br>
 * <br>
 * <code>
 * Input: m = 3, n = 7
 * <br>
 * Output: 28
 * </code>
 */
public class UniquePaths {
    public static int countPaths(int n, int m) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // there is only one way to reach first row(just go right) first column(go down)
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(countPaths(3, 7));
    }
}
