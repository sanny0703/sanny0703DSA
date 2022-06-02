package longestCommonSubsequence.problems;


public class printLCS {

    public static String lcs(String x, String y, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int i = n;
        int j = m;
        String ans = "";
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                ans = x.charAt(i - 1) + ans;
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }


        }
        return ans;

    }

    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";
        //4 {a,b,d,h}
        long a = System.nanoTime();
        System.out.println(lcs(x, y, x.length(), y.length()));
        System.out.println((System.nanoTime() - a) / 10000);

        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println(lcs(X, Y, X.length(), Y.length()));
    }
}
