package Trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <p>
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 */
public class WordBreak {
    // recursive O(2^N)
    // dp solution   O(N^2)
    public static boolean canBreak(String word, List<String> wordDictionary) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordDictionary);
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true; // word ="";
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }

    public static void main(String[] args) {
        String word = "applepenapple";
        List<String> wordDictionary = Arrays.asList("apple", "pen");
        System.out.println(canBreak(word, wordDictionary));
    }
}
