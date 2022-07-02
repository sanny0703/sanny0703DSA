package String;

/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end = 0, longest = 0;
        for (int i = 0; i < n; i++) {
            int[] temp1 = extend(s, i, i); // let's start and odd length palindrome from here
            int[] temp2 = extend(s, i, i + 1); // let's start an even length palindrome here
            if (temp1[1] - temp1[0] + 1 > longest) {
                longest = temp1[1] - temp1[0] + 1;
                start = temp1[0];
                end = temp1[1];
            }
            if (temp2[1] - temp2[0] + 1 > longest) {
                longest = temp2[1] - temp2[0] + 1;
                start = temp2[0];
                end = temp2[1];
            }
        }
        return s.substring(start, end + 1);
    }

    public static int[] extend(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return new int[]{i + 1, j - 1};
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
