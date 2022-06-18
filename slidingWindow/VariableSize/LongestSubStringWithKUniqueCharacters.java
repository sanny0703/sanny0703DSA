package VariableSize;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string you need to print the size of the longest possible substring that has exactly k unique characters.
 * <br>
 * <br>
 * The ides here is to use the same strategy we used for LongestSubArrayWithSumK, but we use a map this time to keep
 * track of unique characters
 */
public class LongestSubStringWithKUniqueCharacters {
    public static int longestSubString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int i = 0, j = 0;
        int count = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) count++;
            if (count > k) {
                while (count > k) {
                    char d = s.charAt(i);
                    map.put(d, map.get(d) - 1);
                    if (map.get(d) == 0) count--;
                    i++;
                }
            }
            if (count == k) {
                ans = Math.max(ans, j - i + 1);
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        //7
        System.out.println(longestSubString("aabacbebebe", 3));
        //4
        System.out.println(longestSubString("aaaa", 1));
        //2
        System.out.println(longestSubString("abaccab",2));
    }
}
