package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 * <p>
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 */
public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int n = ransomNote.length(), m = magazine.length();
        if (n > m) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c)) return false;
            else {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) map.remove(c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }
}
