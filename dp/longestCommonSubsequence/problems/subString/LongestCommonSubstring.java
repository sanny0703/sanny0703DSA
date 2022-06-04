package longestCommonSubsequence.problems.subString;

/**
 * Longest Common Substring(Dynamic Programming)<br>
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.<br>
 * <b>Examples:</b><br>
 *
 * <code>Input : X = “GeeksforGeeks”, y = “GeeksQuiz”<br>
 * Output : 5<br>
 * The longest common substring is “Geeks” and is of length 5.</code>
 */
public class LongestCommonSubstring {
    public static int lcs(String x, String y, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        int ans =0; // variable to store answer
        // first row and col will always be zero
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans,dp[i][j]);
                }
                else dp[i][j] = 0; // because we need a substring here not a subsequence
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";

        long a = System.nanoTime();
        //2 {ab}
        System.out.println(lcs(x, y, x.length(), y.length()));
        System.out.println("Time: "+(System.nanoTime() - a) / 10000);

        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";
        long b = System.nanoTime();
        //10 {Site:Geeks}
        System.out.println(lcs(X, Y, X.length(), Y.length()));
        System.out.println("Time: "+(System.nanoTime() - b) / 10000);
    }
}
