 package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] is a palindrome.
 * <p>
 * <p>
 * Input: words = ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 */
public class PalindromePairs {

    private static TrieNode root;

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) {
                List<Integer> selfPalindromeIndices = getSelfPalindromeIndices(words);
                for (Integer index : selfPalindromeIndices) {
                    ans.add(Arrays.asList(i, index));
                    ans.add(Arrays.asList(index, i));
                }
            } else insert(reverseStr(words[i]), i);
        }
        for (int i = 0; i < words.length; i++) {
            List<Integer> wordIndices = search(words[i], i);
            for (Integer index : wordIndices)
                ans.add(Arrays.asList(i, index));
        }
        return ans;
    }

    private static List<Integer> search(String word, int index) {
        TrieNode node = root;
        List<Integer> wordIndices = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.endWordId > -1 && isPalindrome(word, i, word.length() - 1)) wordIndices.add(node.endWordId);
            if (node.children[currentChar - 'a'] == null) return wordIndices;
            node = node.children[currentChar - 'a'];
        }
        if (node.endWordId > -1 && node.endWordId != index) wordIndices.add(node.endWordId);
        if (!node.belowPalindromeWordIds.isEmpty()) wordIndices.addAll(node.belowPalindromeWordIds);
        return wordIndices;

    }

    private static void insert(String word, int index) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.children[currentChar - 'a'] == null) {
                node.children[currentChar - 'a'] = new TrieNode();
            }
            node = node.children[currentChar - 'a'];
            if (isPalindrome(word, i + 1, word.length() - 1)) {
                node.belowPalindromeWordIds.add(index);
            }
        }
        node.endWordId = index;
    }

    private static class TrieNode {
        int endWordId;
        TrieNode[] children;
        List<Integer> belowPalindromeWordIds;

        public TrieNode() {
            children = new TrieNode[26];
            endWordId = -1;
            belowPalindromeWordIds = new ArrayList<>();
        }
    }

    public static String reverseStr(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static boolean isPalindrome(String s, int start, int end) {
        if (start > end) return false;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    private static List<Integer> getSelfPalindromeIndices(String[] words) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (isPalindrome(words[i], 0, words[i].length() - 1)) ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"}));
    }
}
