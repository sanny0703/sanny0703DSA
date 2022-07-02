package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */
public class FindAllAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), k = p.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        int count = map.size();
        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();
        while (j < n) {
            char charAtJ = s.charAt(j);
            if (map.containsKey(charAtJ)) {
                map.put(charAtJ, map.get(charAtJ) - 1);
                if (map.get(charAtJ) == 0) count--;
            }
            if (j - i + 1 == k) {
                if (count == 0) ans.add(i);
                char charAtI = s.charAt(i);
                if (map.containsKey(charAtI)) {
                    map.put(charAtI, map.get(charAtI) + 1);
                    if (map.get(charAtI) == 1) count++;
                }
                i++;
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
