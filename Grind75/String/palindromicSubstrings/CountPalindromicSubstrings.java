package String.palindromicSubstrings;

/**
 * Given a string s, return the number of palindromic substrings in it.
 * <br>
 * A string is a palindrome when it reads the same backward as forward.
 * <br>
 * A substring is a contiguous sequence of characters within the string.
 * <br>
 * <br>
 * <code>
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * <br>
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * </code>
 */
public class CountPalindromicSubstrings {
    public static int countSubstrings(String s) {
        int numberOfSubstrings = 0;
        for (int i = 0; i < s.length(); i++) {
            numberOfSubstrings += extend(s, i, i); // count odd length palindromes
            numberOfSubstrings += extend(s, i, i + 1); // count even length palindromes
        }
        return numberOfSubstrings;
    }

    private static int extend(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }
}
