package Trie;

/**
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 * <p>
 * Implement the WordDictionary class:
 * <p>
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 * <p>
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 * <p>
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 */
public class DesignAddAndSearchDataStructure {
    private final TrieNode root;

    public DesignAddAndSearchDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] arr, int index, TrieNode node) {
        if (index == arr.length)
            return node.isEnd();
        if (arr[index] != '.') {
            return node.containsKey(arr[index]) && match(arr, index + 1, node.get(arr[index]));
        } else {
            for (TrieNode link : node.links) {
                if (link != null && match(arr, index + 1, link))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DesignAddAndSearchDataStructure wordDictionary = new DesignAddAndSearchDataStructure();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));// return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True

    }
}
