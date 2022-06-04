package longestCommonSubsequence.problems.superSequence;

/**
 * <h3>Shortest Common SuperSequence</h3>
 * Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.<br>
 * <b><i>Examples:</i></b><br>
 *
 * <code>Input:   str1 = "geek",  str2 = "eke"<br>
 * Output: "geeke"</code>
 */
public class ShortestCommonSuperSequence {
    /**
     * when we just append the two strings, we can observe that lcs of two strings is common in both the strings<br>
     * so, we can just remove on instance of lcs from either of the two, we can end up with shortestCommonSuperSequence<br>
     * <code>
     *     m+n - lcs = scs
     * </code>
     *
     */
    public static int scs(String x, String y, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return m + n - dp[n][m];
    }

    public static void main(String[] args) {
        String x = "geek";
        String y = "eke";
        //5{geeke}
        System.out.println(scs(x, y, x.length(), y.length()));

        String a = "AGGTAB";
        String b = "GXTXAYB";
        //9{AGGXTXAYB}
        System.out.println(scs(a, b, a.length(), b.length()));
    }

}
