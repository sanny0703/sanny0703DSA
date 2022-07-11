package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 */
public class SpiralMatrix {
    public static List<Integer> spiral(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int rowBegin = 0, rowEnd = n - 1;
        int colBegin = 0, colEnd = m - 1;
        List<Integer> ans = new ArrayList<>();
        int dir = 0;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            switch (dir) {
                // moving right
                case 0:
                    for (int i = colBegin; i <= colEnd; i++)
                        ans.add(matrix[rowBegin][i]);
                    rowBegin++;
                    break;
                // moving down
                case 1:
                    for (int i = rowBegin; i <= rowEnd; i++)
                        ans.add(matrix[i][colEnd]);
                    colEnd--;
                    break;
                // moving left
                case 2:
                    for (int i = colEnd; i >= colBegin; i--)
                        ans.add(matrix[rowEnd][i]);
                    rowEnd--;
                    break;
                // moving up
                case 3:
                    for (int i = rowEnd; i >= rowBegin; i--)
                        ans.add(matrix[i][colBegin]);
                    colBegin++;
                    break;


            }
            dir = (dir + 1) % 4;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(spiral(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
    }
}
