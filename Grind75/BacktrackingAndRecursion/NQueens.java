package BacktrackingAndRecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 * <p>
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 */
public class NQueens {
    public static List<List<String>> solve(int n) {
        List<List<String>> ans = new ArrayList<>();
        int colIndex = 0; // let's try placing queens column wise
        char[][] board = generateBoard(n);
        backtrack(ans, board, colIndex);
        return ans;
    }

    public static void backtrack(List<List<String>> ans, char[][] board, int colIndex) {
        if (colIndex == board.length) {
            ans.add(constructPossibleBoard(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            // we have to check for columns before columnIndex(all the rows) because we haven't filled those columns columnIndex+1
            if (isValid(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                backtrack(ans, board, colIndex + 1);
                board[i][colIndex] = '.';
            }
        }
    }

    public static boolean isValid(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                /**
                 * no conflict in columns : self explanatory as we put 'Q' col by col.
                 * no conflict in rows : x == i
                 * no conflict in diagonals : Math.abs(x-i) == Math.abs(y-j)
                 * For Math.abs(x-i) == Math.abs(y-j),
                 * if x > i, y > j , x - i = y - j => x + j = y + i
                 * if x < i, y < j, i - x = j - y => x + j = y + i
                 * if x > i, y < j, x - i = j - y => x + y = i + j
                 * if x < i, y > j, i - x = y - j => x + y = i + j
                 */
                if (board[i][j] == 'Q' && ((x + j == y + i) || (x + y == i + j) || (x == i)))
                    return false;
            }
        }
        return true;
    }

    public static char[][] generateBoard(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }

    public static List<String> constructPossibleBoard(char[][] board) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = "";
            for (char c : board[i])
                s += c;
            ans.add(s);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(4));
    }
}
