package longestCommonSubsequence.problems.palindrome;

/**
 * <h3>Longest Palindromic Subsequence</h3>
 * Given a sequence, find the length of the longest palindromic subsequence in it.<br>
 *<code> Example :<br>
 * Input:"bbbab"<br>
 * Output:4<br>
 * </code>
 */
public class LongestPalindromicSubsequence {
    /**
     *
     * LPS is a subset LCS( all palindromic sequences are also present in all sequences of a string)<br>
     * LPS(s) = LCS(s,reverse(s))
     */
    public static int lps(String s) {
        StringBuilder s2 = new StringBuilder(s);
        String st = s2.reverse().toString();
        int n = s.length(), m = st.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == st.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {
        String s = "bbbab";
        //4 { bbbb}
        System.out.println(lps(s));
        // {bb}
        System.out.println(lps("cbbd"));
    }
}
