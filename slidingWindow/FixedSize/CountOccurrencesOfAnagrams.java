package FixedSize;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a word pat and a text txt. Return the count of the occurrences of anagrams of the word in the text.
 * <br>
 * <br>
 * <code>Example 1:<br>
 * <p>
 * Input:<br>
 * txt = forxxorfxdofr<br>
 * pat = for<br>
 * Output: 3<br>
 * Explanation: for, orf and ofr appears in the txt, hence answer is 3.<br>
 * <br>
 * Example 2:<br>
 * <p>
 * Input:<br>
 * txt = aabaabaa<br>
 * pat = aaba<br>
 * Output: 4<br>
 * Explanation: aaba is present 4 times in txt
 */
public class CountOccurrencesOfAnagrams {
    public static int countAnagramOccurrences(String word, String pattern) {
        int k = pattern.length(); // size of window
        Map<Character, Integer> map = new HashMap<>();
        for (char c : pattern.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int count = map.size();// when it becomes zero the occurrence of chars in window matches that of pattern
        int ans = 0; // variable to store our count of anagram occurrences
        int i = 0;
        for (int j = 0; j < word.length(); j++) {
            char c = word.charAt(j);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) count--; // one of the char pattern matches
            }
            if (j - i + 1 == k) {
                if (count == 0) ans++;
                char d = word.charAt(i);
                if (map.containsKey(d)) {
                    map.put(d, map.get(d) + 1);
                    // if the charAt(i) is in map,and it's count becomes 1 when we add it to map,increase the count
                    if (map.get(d) == 1) count++;
                }
                i++; // slide the window
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //3
        System.out.println(countAnagramOccurrences("forxxorfxdofr", "for"));
        //4
        System.out.println(countAnagramOccurrences("aabaabaa", "aaba"));
    }
}
