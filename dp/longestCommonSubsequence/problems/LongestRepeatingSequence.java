package longestCommonSubsequence.problems;

/**
 * <h3>Longest Repeating Subsequence</h3>
 * Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string character at same position,<br>
 * i.e., any i’th character in the two subsequences should not have the same index in the original string.<br>
 * <code>Example:<br>
 * Input: str = "aab"<br>
 * Output: "a"<br>
 * The two subsequence are 'a'(first) and 'a' <br>
 * (second). Note that 'b' cannot be considered <br>
 * as part of subsequence as it would be at same<br>
 * index in both.<br></code>
 */
public class LongestRepeatingSequence {
    /**
     * we just have to add the condition that <code>i!= j</code> in lcs with itself, we get the longest repeating subsequence
     */
    public static int lrs(String x) {
        int n = x.length(), m = x.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == x.charAt(j - 1) && i != j) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        //3{ABD}
        System.out.println(lrs("AABEBCDD"));
    }
}
