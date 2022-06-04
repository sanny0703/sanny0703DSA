package longestCommonSubsequence.problems.palindrome;

/**
 * Give a string return the min nof of deletions required to make it a palindrome<br>
 * <code><h3>Example:</h3>
 * Input : aebcbda<br>
 * Output : 2<br>
 * Remove characters 'e' and 'd'<br>
 * Resultant string will be 'abcba'<br>
 * which is a palindromic string<br>
 * </code>
 */
public class MinDeletionsToMakePalindrome {
    /**
     *length of String - lps gives us the min deletions to make palindrome
     */
    public static int minDeletions(String x,int n){
        StringBuilder sb = new StringBuilder(x);
        String y = sb.reverse().toString();
        int m = y.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(x.charAt(i-1)==y.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return n-dp[n][m];
    }
}
