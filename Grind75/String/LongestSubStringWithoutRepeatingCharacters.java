package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubStringWithoutRepeatingCharacters {
    public static int longestSubString(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, longest = 0;
        while (j < n) {
            char charAtJ = s.charAt(j);
            map.put(charAtJ, map.getOrDefault(charAtJ, 0) + 1);
            if (map.get(charAtJ) != 1) {
                while (map.get(charAtJ) != 1) {
                    char charAtI = s.charAt(i);
                    map.put(charAtI, map.get(charAtI) - 1);
                    i++;
                }
            }
            longest = Math.max(longest, j - i + 1);
            j++;
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestSubString("abcabcbb"));
    }
}
