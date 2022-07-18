package Graph;

import java.util.*;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * <p>
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 * <p>
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 */
public class WordLadder {
    public static int countSteps(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int countSteps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) return countSteps;

                for (int i = 0; i < currentWord.length(); i++) {
                    char[] charArray = currentWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[i] = c;
                        String word = new String(charArray);
                        if (words.contains(word) && !visited.contains(word)) {
                            queue.offer(word);
                            visited.add(word);
                        }

                    }
                }
            }
            countSteps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(countSteps("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
