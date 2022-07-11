package BacktrackingAndRecursion.SudokuSolver;

import java.util.Arrays;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * A sudoku solution must satisfy all of  following rules:
 * <p>
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 * <p>
 * Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 */
public class SolveSudoku {
    public static String[][] solve(String[][] board) {
        backtrack(board);
        return board;
    }

    public static boolean backtrack(String[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j].equals(".")) {
                    for (int c = 1; c <= 9; c++) {
                        if (isValid(board, i, j, "" + c)) {
                            board[i][j] = "" + c;
                            if (backtrack(board))
                                return true;
                            else
                                board[i][j] = ".";
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(String[][] board, int row, int col, String c) {
        int blockRow = (row / 3) * 3, blockCol = (col / 3) * 3;
        for (int i = 0; i < 9; i++) {
            if (board[row][i].equals(c))
                return false;
            if (board[i][col].equals(c))
                return false;
            if (board[blockRow + i / 3][blockCol + i % 3].equals(c))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solve(new String[][]{
                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        })));
    }
}
