package longestCommonSubsequence.problems;

/**
 * print the longest Repeating subsequence
 */
public class printLRS {
    public static String lrs(String x) {
        int n = x.length(), m = x.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == x.charAt(j - 1) && i != j) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        StringBuilder ans = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == x.charAt(j - 1) && i != j) {
                ans.append(x.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) i--;
                else j--;
            }
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        //3{ABD}
        System.out.println(lrs("AABEBCDD"));
    }
}
