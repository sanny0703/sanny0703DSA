package DynamicProgramming.LIS;

/**
 * topdown approach for LIS
 */
public class TopDown {
    public static int LIS(int[] arr) {
        int n = arr.length;
        if (n == 1) return 1;
        // we are using n+1 cause prev goes to -1,we can't have -1 as index,so everything at prev will be stored at prev+1
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {

                int include = Integer.MIN_VALUE;
                if (j == -1 || arr[i] > arr[j]) include = 1 + dp[i + 1][i + 1]; // prev+1
                int ignore = dp[i + 1][j + 1];//prev+1
                dp[i][j + 1] = Math.max(include, ignore); // prev+1
            }
        }
        return dp[0][0];//prev+1
    }

    public static void main(String[] args) {
        System.out.println(LIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(LIS(new int[]{0, 1, 0, 3, 2, 3}));
    }
}
