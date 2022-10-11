package String.palindromicSubstrings;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a String print all the palindromic substrings of that string
 */
public class printAllPalindromicSubstrings {
    public static List<String> printPalindromicSubstrings(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i, result); // let's try odd length palindromes
            extend(s, i, i + 1, result); // let's try even length palindromes
        }
        return result;
    }

    private static void extend(String s, int i, int j, List<String> result) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            result.add(s.substring(i, j + 1));
            i--;
            j++;
        }
    }

    public static void main(String[] args) {
        System.out.println(printPalindromicSubstrings("abc"));
        System.out.println(printPalindromicSubstrings("aaa"));
    }
}
