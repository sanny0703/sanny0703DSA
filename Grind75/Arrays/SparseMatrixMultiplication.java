package Arrays;

import java.util.Arrays;

/**
 * Given two sparse matrices A and B, return the result of AB.
 *
 *  You may assume that A's column number is equal to B's row number.
 *
 *  Example:
 *
 *  A = [
 *  [ 1, 0, 0],
 *  [-1, 0, 3]
 *  ]
 *
 *  B = [
 *  [ 7, 0, 0 ],
 *  [ 0, 0, 0 ],
 *  [ 0, 0, 1 ]
 *  ]
 *
 *         |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 *  AB =   | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *                      | 0 0 1 |
 * 2*3 ** 3*2 == 2*2
 * for multiplication of matrices A columns and b rows should be same size
 * thr resultant matrix will be of size A rows * B cols
 */
public class SparseMatrixMultiplication {
    public static int[][] sparseMultiplication(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] != 0)// matrix is sparse,so better ignore 0,as we will end up with 0 values
                {
                    for (int j = 0; j < B[0].length; j++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(sparseMultiplication(new int[][]{{-1, 0, 0}, {-1, 0, 3}}, new int[][]{{7, 0, 0}, {0, 0, 0}, {0, 0, 1}})));
    }
}
