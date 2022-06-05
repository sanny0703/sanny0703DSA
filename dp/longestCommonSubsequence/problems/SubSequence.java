package longestCommonSubsequence.problems;

/**
 * give two string x and y, check whether x is subsequence of y
 */
public class SubSequence {

    public static boolean dpIsSubsequence(String x, String y, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return n == dp[n][m];
    }

    public static boolean isSubsequence(String x, String y, int n, int m) {
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                i--;
                j--;
            } else j--;
        }
        return i == 0;
    }

    public static void main(String[] args) {
        String x = "AXY";
        String y = "ADXCPY";
        // true
        System.out.println(dpIsSubsequence(x, y, x.length(), y.length()));
        // true
        System.out.println(isSubsequence(x, y, x.length(), y.length()));
    }
}
