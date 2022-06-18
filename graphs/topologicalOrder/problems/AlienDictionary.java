package topologicalOrder.problems;

import java.util.*;

/**
 * There is a new alien language which uses the latin alphabet.
 * However, the order among letters are unknown to you.
 * You receive a list of non-empty words from the dictionary,
 * where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.
 * <br>
 * <br>
 * <code>
 * Input：["wrt","wrf","er","ett","rftt"]<br>
 * Output："wertf"<br>
 * Explanation：<br>
 * from "wrt"and"wrf" ,we can get 't'<'f'<br>
 * from "wrt"and"er" ,we can get 'w'<'e'<br>
 * from "er"and"ett" ,we can get 'r'<'t'<br>
 * from "ett"and"rftt" ,we can get 'e'<'r'<br>
 * So return "wertf"<br>
 * </code>
 */
public class AlienDictionary {
    public static String getOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.put(c, 0);
                adj.put(c, new ArrayList<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i], word2 = words[i + 1];
            // this where lexicographically rule fails, so we just return an empty string
            if (word1.length() > word2.length() && word1.startsWith(word2))
                return "";
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char parent = word1.charAt(j), child = word2.charAt(j);
                if (parent != child) {
                    adj.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child) + 1);
                    break; // we only need the first non diff character
                }
            }
        }
        Queue<Character> queue = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                queue.offer(entry.getKey());
        }
        StringBuilder ans = new StringBuilder();
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            ans.append(cur);
            for (char neighbor : adj.get(cur)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0)
                    queue.offer(neighbor);
            }
        }
        if (ans.length() != inDegree.size()) return "";
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(getOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
        System.out.println(getOrder(new String[]{"zy", "zx"}));
    }
}
