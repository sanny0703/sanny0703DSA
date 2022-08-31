package Graph;

import java.util.*;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists.
 * Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
 *
 *Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * Explanation: There are 2 shortest transformation sequences:
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: []
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 */
public class WordLadder2 {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!words.contains(endWord))
            return res;
        Set<String> visited = new HashSet<>();
        Queue<List<String>> queue = new ArrayDeque<>();
        queue.offer(Arrays.asList(beginWord));
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                List<String> curList = queue.poll();
                String lastWord = curList.get(curList.size() - 1);
                List<String> neighbors = getNeighbors(lastWord, words);
                for (String neighbor : neighbors) {
                    List<String> newList = new ArrayList<>(curList);
                    newList.add(neighbor);
                    visited.add(neighbor);
                    if (neighbor.equals(endWord))
                        res.add(newList);
                    else queue.offer(newList);
                }
            }
            for (String word : visited)
                words.remove(word);
        }
        return res;
    }

    public static List<String> getNeighbors(String word, Set<String> words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] chars = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String newStr = new String(chars);
                if (words.contains(newStr))
                    res.add(newStr);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
