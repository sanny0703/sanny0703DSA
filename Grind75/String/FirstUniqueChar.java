package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * <p>
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueChar {
    public static int firstUniqueIndex(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        for (int i = 0; i < s.length(); i++)
            if (counter.get(s.charAt(i)) == 1) return i;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueIndex("sanjays"));
    }
}
