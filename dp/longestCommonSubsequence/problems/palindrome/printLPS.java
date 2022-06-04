package longestCommonSubsequence.problems.palindrome;

/**
 * print the longest palindromic subSequence
 */
public class printLPS {

    public static String lps(String x) {
        int n = x.length();
        StringBuilder sb = new StringBuilder(x);
        String y = sb.reverse().toString();
        int m = y.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        sb = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                sb.append(x.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) i--;
                else j--;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        String s = "bbbab";
        //4 { bbbb}
        System.out.println(lps(s));
        //2{bb}
        System.out.println(lps("cbbd"));

    }
}
