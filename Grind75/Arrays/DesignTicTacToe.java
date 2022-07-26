package Arrays;

/**
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 * <p>
 * You may assume the following rules:
 * <p>
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 * <p>
 * Follow up:
 * Could you do better than O(n2) per move() operation?
 * <p>
 * <p>
 * Example:
 * Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.
 * <p>
 * TicTacToe toe = new TicTacToe(3);
 * <p>
 * toe.move(0, 0, 1); -> Returns 0 (no one wins)
 * |X| | |
 * | | | | // Player 1 makes a move at (0, 0).
 * | | | |
 * <p>
 * toe.move(0, 2, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * | | | | // Player 2 makes a move at (0, 2).
 * | | | |
 * <p>
 * toe.move(2, 2, 1); -> Returns 0 (no one wins)
 * |X| |O|
 * | | | | // Player 1 makes a move at (2, 2).
 * | | |X|
 * <p>
 * toe.move(1, 1, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * | |O| | // Player 2 makes a move at (1, 1).
 * | | |X|
 * <p>
 * toe.move(2, 0, 1); -> Returns 0 (no one wins)
 * |X| |O|
 * | |O| | // Player 1 makes a move at (2, 0).
 * |X| |X|
 * <p>
 * toe.move(1, 0, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * |O|O| | // Player 2 makes a move at (1, 0).
 * |X| |X|
 * <p>
 * toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
 * |X| |O|
 * |O|O| | // Player 1 makes a move at (2, 1).
 * |X|X|X|
 * Follow up:
 * Could you do better than O(n^2) per move() operation?
 */
public class DesignTicTacToe {
    private static int[][] matrix;
    private static int[] rows;
    private static int[] cols;
    private static int[] diagonals;

    public DesignTicTacToe(int n) {
        matrix = new int[n][n];
        rows = new int[matrix.length];
        cols = new int[matrix.length];
        diagonals = new int[2]; // only two diagonals no matter the n
    }

    public static int move(int row, int col, int player) {
        int val = player == 1 ? 1 : -1;
        rows[row] += val;
        cols[col] += val;
        if (row == col) diagonals[1] += val;
        if (row + col == matrix.length - 1) diagonals[2] += val;
        // if either row or col or diagonals fill with same value we either get +n or -n, so Math.abs()
        if (Math.abs(rows[row]) == matrix.length || Math.abs(cols[col]) == matrix.length ||
                Math.abs(diagonals[1]) == matrix.length || Math.abs(diagonals[2]) == matrix.length)
            return player;
        return 0;
    }

    public static int naiveMove(int row, int col, int player) {
        matrix[row][col] = player;
        boolean win = true;
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[row][j] != player) {
                win = false;
                break;
            }
        }
        if (win) return player;
        win = true;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] != player) {
                win = false;
                break;
            }
        }
        if (win) return player;
        win = true;
        for (int i = 0; i < matrix.length; i++) { // first diagonal (i = j)
            if (matrix[i][i] != player) {
                win = false;
                break;
            }
        }
        if (win) return player;
        for (int i = 0; i < matrix.length; i++) { // second diagonal (i + j = matrix.length-1)
            if (matrix[i][matrix.length - 1 - i] != player) {
                win = false;
                break;
            }
        }
        if (win) return player;
        return 0;
    }
}
