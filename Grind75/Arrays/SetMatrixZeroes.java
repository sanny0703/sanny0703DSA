package Arrays;

import java.util.Arrays;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * <p>
 * You must do it in place.
 * <p>
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 */
public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean firstRow = false, firstCol = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = true;
                    if (j == 0) firstCol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        if (firstRow) {
            for (int j = 0; j < m; j++)
                matrix[0][j] = 0;
        }
        if (firstCol) {
            for (int i = 0; i < n; i++)
                matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
