package longestCommonSubsequence.problems;

/**
 * Minimum number of deletions and insertions to transform one string into another<br>
 * Given two strings ‘str1’ and ‘str2’ of size m and n respectively.<br>
 * The task is to remove/delete and insert minimum number of characters from/in str1 to transform it into str2.,br>
 * It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.<br>
 * <code>
 *   <i><h3>Example:</h3>
 *   Input : str1 = "geeksforgeeks", str2 = "geeks"<br>
 *   Output : Minimum Deletion = 8<br>
 *           Minimum Insertion = 0 <br></i>
 * </code>
 */
public class MinInsertionsDeletionsToConvertAToB {
    /**
     *
     * <code>
     *     heap --> pea<br>
     *     heap --->ea (2 deletions)<br>
     *     ea ---->pea (1 insertion) <br>
     *     # deletions a.length()-lcs<br>
     *     # insertions b.length()-lcs<br>
     * </code>
     */
    public static int minInsertionsAndDeletions(String x, String y, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return n - dp[n][m] + m - dp[n][m]; // n-lcs+m-lcs
    }

    public static void main(String[] args) {
        String x = "heap";
        String y = "pea";
        // 3(2 deletions +1 insertion)
        System.out.println(minInsertionsAndDeletions(x, y, x.length(), y.length()));

        String X = "geeksforgeeks";
        String Y = "geeks";
        // 8( 8 deletions + 0 insertions)
        System.out.println(minInsertionsAndDeletions(X, Y, X.length(), Y.length()));
    }
}
