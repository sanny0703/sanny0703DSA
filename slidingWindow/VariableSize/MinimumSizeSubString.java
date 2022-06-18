package VariableSize;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s<br>
 * such that every character in t (including duplicates) is included in the window.<br>
 * If there is no such substring, return the empty string "".<br>
 * <br>
 * <br>
 * <code>
 * Input: s = "ADOBECODEBANC", t = "ABC"<br>
 * Output: "BANC"<br>
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * </code>
 */
public class MinimumSizeSubString {
    public static String smallestSubString(String s, String t) {
        int n = s.length(), m = t.length();
        if (m > n || m == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();// reduce the count to 0 for a window hit
        int minLength = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int i = 0, j = 0;
        while (j < n) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) count--;
            }
            while (count == 0) { // once we hit the window we try to minimize the window as small as possible
                if (minLength > j - i + 1) {
                    minLength = j - i + 1;
                    start = i;
                    end = j;
                }
                char d = s.charAt(i);
                if (map.containsKey(d)) {
                    map.put(d, map.get(d) + 1);
                    if (map.get(d) == 1) count++;
                }
                i++;
            }
            j++;
        }
        return minLength != Integer.MAX_VALUE ? s.substring(start, end + 1) : "";
    }

    public static void main(String[] args) {
        System.out.println(smallestSubString("ADOBECODEBANC", "ABC"));
    }
}
