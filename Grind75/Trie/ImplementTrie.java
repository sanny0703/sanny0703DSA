package Trie;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 * <p>
 * Implement the Trie class:
 * <p>
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix, and false otherwise.
 */
public class ImplementTrie {
    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar))
                node.put(currentChar, new TrieNode());
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.containsKey(currentChar)) {
                node = node.get(currentChar);
            } else
                return false;
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            if (node.containsKey(currentChar))
                node = node.get(currentChar);
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("sanjay");
        trie.insert("sanny");
        trie.insert("uppala");
        trie.insert("kumar");
        System.out.println(trie.search("uppala"));
        System.out.println(trie.startsWith("upp"));
        System.out.println(trie.search("jyothi"));
    }
}
