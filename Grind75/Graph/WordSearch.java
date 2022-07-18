package Graph;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 */
public class WordSearch {
    public static boolean search(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) if (dfs(i, j, n, m, word, board, 0)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(int x, int y, int n, int m, String word, char[][] board, int index) {
        if (index == word.length()) return true;
        if (x < 0 || x > n - 1 || y < 0 || y > m - 1 || word.charAt(index) != board[x][y]) return false;
        char c = board[x][y];
        board[x][y] = '#';// this is visited for current dfs call
        boolean res = dfs(x - 1, y, n, m, word, board, index + 1) || dfs(x + 1, y, n, m, word, board, index + 1) || dfs(x, y - 1, n, m, word, board, index + 1) || dfs(x, y + 1, n, m, word, board, index + 1);
        board[x][y] = c; // make it unvisited
        return res;
    }
}
