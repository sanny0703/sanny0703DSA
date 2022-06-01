package knapsack.unboundedKnapsack;

/***
 * <b> Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.<br> Determine the  maximum value obtainable by cutting up the rod and selling the pieces.<br>
 * <h2>Example:</h2>
 * <i>if length of the rod is 8 and the values of different pieces are given as following<br><code>length   | 1   2   3   4   5   6   7   8 <br>
 * --------------------------------------------<br>
 * price    | 1   5   8   9  10  17  17  20</code>,<br> then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * </b></i>
 */
public class RodCutting {

    public static int cutRod(int[] prices, int n) {
        int[] length = new int[n];
        for (int i = 0; i < n; i++) length[i] = i + 1;
        int N = length.length;
        int[][] dp = new int[n + 1][N + 1];
        // 0 case is always zero here, so no need to worry about first row and col
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (length[i - 1] <= j) dp[i][j] = Math.max(prices[i - 1]
                                + dp[i][j - length[i - 1]] // if we can use i , we might also use it in the future, so we are not going to drop considering it
                        , dp[i - 1][j]); // if we cannot use i , which means we won't be needing in the future for this call
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][N];
    }

    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(prices, 8));
    }
}
