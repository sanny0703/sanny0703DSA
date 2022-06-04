package longestCommonSubsequence.problems.subString;

/**
 * print the longest common substring of two strings
 */
public class printLongestCommonSubString {
    public static String lcs(String x, String y, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        int len = 0, row = 0, col = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (len < dp[i][j]) {
                        len = dp[i][j];
                        row = i;
                        col = j;
                    }
                } else dp[i][j] = 0;
            }
        }
        if (len == 0) return "";
        StringBuilder ans = new StringBuilder();
        while (dp[row][col] != 0) {
            ans.append(x.charAt(row - 1));
            row--;
            col--;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";

        long a = System.nanoTime();
        //2 {ab}
        System.out.println(lcs(x, y, x.length(), y.length()));
        System.out.println("Time: " + (System.nanoTime() - a) / 10000);

        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";
        long b = System.nanoTime();
        //10 {Site:Geeks}
        System.out.println(lcs(X, Y, X.length(), Y.length()));
        System.out.println("Time: " + (System.nanoTime() - b) / 10000);
    }
}
