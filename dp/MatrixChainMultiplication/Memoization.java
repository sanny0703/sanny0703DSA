package MatrixChainMultiplication;

public class Memoization {
    private static int[][] dp;

    public static int mcm(int[] arr) {
        int n = arr.length;
        int i = 1, j = n - 1;
        dp = new int[n][n];
        return solve(arr, i, j);
    }

    public static int solve(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != 0) return dp[i][j];
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            dp[i][j] = Math.min(dp[i][j], solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j]);
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        //2600
        // (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30
        System.out.println(mcm(arr));

        int[] arr2 = {10, 20, 30, 40, 30};
        // 30000
        //((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30
        System.out.println(mcm(arr2));
    }
}
