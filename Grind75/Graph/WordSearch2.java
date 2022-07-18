package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 */
public class WordSearch2 {
    public static void dfs(int x, int y, int n, int m, TrieNode node, List<String> foundWords, char[][] board) {
        if (x < 0 || x >= n || y < 0 || y >= m) return;
        char currentChar = board[x][y];
        if (currentChar == '#' || node.children[currentChar - 'a'] == null) return;
        node = node.children[currentChar - 'a'];
        if (node.word != null) {
            foundWords.add(node.word);
            node.word = null;
        }
        board[x][y] = '#'; // mark it as visited for current dfs call
        dfs(x - 1, y, n, m, node, foundWords, board);
        dfs(x + 1, y, n, m, node, foundWords, board);
        dfs(x, y - 1, n, m, node, foundWords, board);
        dfs(x, y + 1, n, m, node, foundWords, board);
        board[x][y] = currentChar; // un mark it after dfs returns
    }

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length, m = board[0].length;
        Trie trie = new Trie();
        for (String word : words)
            trie.insert(word);
        List<String> foundWords = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, n, m, trie.root, foundWords, board);
            }
        }
        return foundWords;
    }

    static class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            children = new TrieNode[26]; // only lowercase letters
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (node.children[currentChar - 'a'] == null) node.children[currentChar - 'a'] = new TrieNode();
                node = node.children[currentChar - 'a'];
            }
            node.word = word;
        }
    }

}
