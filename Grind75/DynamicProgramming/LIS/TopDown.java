package DynamicProgramming.LIS;

/**
 * topdown approach for LIS
 */
public class TopDown {
    public static int LISBest(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;
        int[] dp = new int[n];
        dp[0] = 1; // ending at 1 st element
        int longest = 1;
        for (int i = 1; i < n; i++) {
            int maxBeforeI = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    maxBeforeI = Math.max(maxBeforeI, dp[j]);
            }
            dp[i] = 1 + maxBeforeI;
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(LISBest(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(LISBest(new int[]{0, 1, 0, 3, 2, 3}));
    }
}
