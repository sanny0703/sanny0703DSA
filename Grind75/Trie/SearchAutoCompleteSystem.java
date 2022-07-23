package Trie;

import java.util.*;

/**
 * Design a search autocomplete system for a search engine.
 * Users may input a sentence (at least one word and end with a special character '#').
 * For each character they type except '#', you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.
 * <p>
 * Here are the specific rules:
 * <p>
 * The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
 * The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one).
 * If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
 * If less than 3 hot sentences exist, then just return as many as you can.
 * When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
 * Your job is to implement the following functions:
 * <p>
 * The constructor function:
 * <p>
 * AutocompleteSystem(String[] sentences, int[] times): This is the constructor.
 * The input is historical data. Sentences is a string array consists of previously typed sentences.
 * Times is the corresponding times a sentence has been typed. Your system should record these historical data.
 * <p>
 * Now, the user wants to input a new sentence. The following function will provide the next character the user types:
 * <p>
 * List<String> input(char c): The input c is the next character typed by the user.
 * The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#').
 * Also, the previously typed sentence should be recorded in your system.
 * The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.
 * <p>
 * <p>
 * Example:
 * <p>
 * Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
 * The system have already tracked down the following sentences and their corresponding times:
 * "i love you" : 5 times
 * "island" : 3 times
 * "ironman" : 2 times
 * "i love leetcode" : 2 times
 * <p>
 * Now, the user begins another search:
 * <p>
 * Operation: input('i')
 * Output: ["i love you", "island","i love leetcode"]
 * Explanation:
 * There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree.
 * Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman".
 * Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
 * <p>
 * Operation: input(' ')
 * Output: ["i love you","i love leetcode"]
 * Explanation:
 * There are only two sentences that have prefix "i ".
 * <p>
 * Operation: input('a')
 * Output: []
 * Explanation:
 * There are no sentences that have prefix "i a".
 * <p>
 * Operation: input('#')
 * Output: []
 * Explanation:
 * The user finished the input, the sentence "i a" should be saved as a historical sentence in system.
 * And the following input will be counted as a new search.
 * <p>
 * <p>
 * Note:
 * <p>
 * The input sentence will always start with a letter and end with '#', and only one blank space will exist between two words.
 * The number of complete sentences that to be searched won't exceed 100. The length of each sentence including those in the historical data won't exceed 100.
 * Please use double-quote instead of single-quote when you write test cases even for a character input.
 * Please remember to RESET your class variables declared in class AutocompleteSystem, as static/class variables are persisted across multiple test cases. Please see here for more details.
 */
public class SearchAutoCompleteSystem {
    private final TrieNode root;
    private TrieNode current;
    private StringBuilder sb;

    public SearchAutoCompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        current = root;
        sb = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }

    public static void main(String[] args) {
        SearchAutoCompleteSystem s = new SearchAutoCompleteSystem(new String[]{}, new int[]{});
        s.insert("sanjay", 1);
        s.insert("kumar", 2);
        s.insert("sanjay kumar", 3);
        s.insert("sanny", 5);
        System.out.println(s.input('s'));
    }

    public List<String> input(char c) {
        if (c == '#') {
            insert(sb.toString(), 1);
            current = root;
            sb = new StringBuilder();
        }
        sb.append(c);
        if (current != null) current = current.children.get(c);
        if (current == null) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        for (TrieNode node : current.top3) {
            ans.add(node.s);
        }
        return ans;
    }

    public void insert(String sentence, int times) {
        TrieNode node = root;
        for (int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);
            if (!node.children.containsKey(currentChar)) node.children.put(currentChar, new TrieNode());
            node = node.children.get(currentChar);
        }
        node.s = sentence;
        node.times += times;
        TrieNode leaf = node;
        node = root;
        // travel again down the path to update top 3
        for (char c : sentence.toCharArray()) {
            node = node.children.get(c);
            node.update(leaf);
        }

    }

    class TrieNode implements Comparable<TrieNode> {
        Map<Character, TrieNode> children;
        int times;
        String s;
        List<TrieNode> top3;

        public TrieNode() {
            children = new HashMap<>();
            times = 0;
            top3 = new ArrayList<>();
        }

        @Override
        public int compareTo(TrieNode that) {
            if (this.times != that.times) return that.times - this.times;
            return this.s.compareTo(that.s);
        }

        public void update(TrieNode node) {
            if (!top3.contains(node)) top3.add(node);
            Collections.sort(top3);
            if (top3.size() > 3) top3.remove(top3.size() - 1);
        }
    }


}
