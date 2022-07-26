package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * <p>
 * For example, Given s = “eceba” and k = 2,
 * <p>
 * T is "ece" which its length is 3.
 */
public class MaximumSubstringWithAtMostKDistinctChars {
    public static int maxSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, i = 0, j = 0;
        while (j < s.length()) {
            char charAtJ = s.charAt(j);
            map.put(charAtJ, map.getOrDefault(charAtJ, 0) + 1);
            if (map.size() > k) {
                while (map.size() > k) {
                    char charAtI = s.charAt(i);
                    map.put(charAtI, map.get(charAtI) - 1);
                    if (map.get(charAtI) == 0)
                        map.remove(charAtI);
                    i++;
                }
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubstring("eceba", 2));
    }
}
