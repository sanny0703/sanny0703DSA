package DynamicProgramming;

/**
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <br>
 * <br>
 * <code>
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * <br>
 * Output: 4
 * </code>
 */
public class MaximalSquare {
    public static int maxArea(String[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];
        int maxLength = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (matrix[i - 1][j - 1].equals("1")) {
                    dp[i][j] = 1 // the current square length
                    + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength * maxLength;
    }

    public static void main(String[] args) {
        //4
        System.out.println(maxArea(new String[][]{{"1", "0", "1", "0", "0"}, {"1", "0", "1", "1", "1"}, {"1", "1", "1", "1", "1"}, {"1", "0", "0", "1", "0"}}));
    }
}
