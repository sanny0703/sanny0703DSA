package VariableSize;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <br>
 * <br>
 * <code> Example:<br>
 * Input: s = "pwwkew"<br>
 * Output: 3<br>
 * Explanation: The answer is "wke", with the length of 3.<br>
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring</code>
 */
public class LongestSubStringWithAllUniqueCharacters {
    public static int longestSubString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > 1) {
                while (map.get(c) > 1) {
                    char d = s.charAt(i);
                    map.put(d, map.get(d) - 1);
                    i++;
                }
            }
            if (map.get(c) == 1) {
                ans = Math.max(ans, j - i + 1);
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        //3
        System.out.println(longestSubString("pwwkew"));
    }
}
