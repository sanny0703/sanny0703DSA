package VariableSize;

import java.util.HashMap;
import java.util.Map;

/**
 * John is at a toy store help him pick maximum number of toys. <br>
 * He can only select in a continuous manner, and he can select only two types of toys.
 * <br>
 * <br>
 * The idea is same as longest SubString with K unique Characters but the k here is 2
 */
public class PickToys {
    public static int maxToys(String s) {
        int k = 2; // only two type
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int i = 0, j = 0;
        int count = 0; // maintains count of distinct characters
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
        //4
        System.out.println(maxToys("abaccab"));
    }
}
