package basicProblems;

/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix arr.<br>
 * This matrix has the following properties:<br><br>
 * <p>
 * Integers in each row are sorted from left to right.<br>
 * The first integer of each row is greater than the last integer of the previous row.<br><br>
 *
 * <code>
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3<br>>
 * Output: true
 * </code>
 */
public class SearchInRowColSortedMatrix {

    public static boolean search(int[][] arr, int target) {
        int n = arr.length, m = arr[0].length;
        int i = 0, j = m - 1;
        while (i >= 0 && j >= 0 && i < n && j < m) {
            if (arr[i][j] == target)
                return true;
            if (arr[i][j] > target)
                j--;
            else i++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        //true
        System.out.println(search(arr, 30));
        // false
        System.out.println(search(arr, 35));

    }
}
