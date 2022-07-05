package BinarySearch;

/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 */
public class SearchMatrix {
    public static boolean search(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m - 1;
        while (i >= 0 && j >= 0 && i < n && j < m) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target)
                j--;
            else i++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
    }
}
