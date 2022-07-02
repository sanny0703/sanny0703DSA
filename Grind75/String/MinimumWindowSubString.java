package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 */
public class MinimumWindowSubString {
    public static String shortestSubstring(String s, String t) {
        int n = s.length(), m = t.length();
        if (n < m) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int count = map.size();
        int i = 0, j = 0, start = 0, end = 0, shortest = Integer.MAX_VALUE;
        while (j < n) {
            char charAtJ = s.charAt(j);
            if (map.containsKey(charAtJ)) {
                map.put(charAtJ, map.get(charAtJ) - 1);
                if (map.get(charAtJ) == 0) count--;
            }
            if (count == 0) { // once we found the substring ,try to shrink it as small as possible
                while (count == 0) {
                    if (shortest > j - i + 1) {
                        shortest = j - i + 1;
                        start = i;
                        end = j;
                    }
                    char charAtI = s.charAt(i);
                    if (map.containsKey(charAtI)) {
                        map.put(charAtI, map.get(charAtI) + 1);
                        if (map.get(charAtI) == 1) count++;
                    }
                    i++;
                }
            }
            j++;
        }
        return shortest == Integer.MAX_VALUE ? "" : s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(shortestSubstring("ADOBECODEBANC", "ABC"));
    }
}
