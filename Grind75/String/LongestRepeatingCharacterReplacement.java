package String;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 * <p>
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 * <p>
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 */
public class LongestRepeatingCharacterReplacement {
    // similar to the longest substring with k unique characters but here we can replace those k characters
    public static int longestSubString(String s, int k) {
        int n = s.length();
        int i = 0, j = 0, longest = 0, maxCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < n) {
            char charAtJ = s.charAt(j);
            map.put(charAtJ, map.getOrDefault(charAtJ, 0) + 1);
            // maxCount maintains the frequency of  the largest frequency character
            // it gets updated for every new char introduced
            maxCount = Math.max(maxCount, map.get(charAtJ));
            // length of the substring - max frequency char should always be < k,since we can only replace k chars
            if (j - i + 1 - maxCount > k) {
                while (j - i + 1 - maxCount > k) {
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
        //4
        //Replace the one 'A' in the middle with 'B' and form "AABBBBA".
        //The substring "BBBB" has the longest repeating letters, which is 4.
        System.out.println(longestSubString("AABABBA",1));
    }
}
