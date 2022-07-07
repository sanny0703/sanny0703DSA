package Binary;

import java.util.Arrays;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
 * ans[i] is the number of 1's in the binary representation of i.
 * <p>
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 */
public class CountingBits {
    public static int solve(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n % 2 == 0) return solve(n / 2);
        else return 1 + solve(n / 2);
    }

    //O(NlogN)
    public static int[] countNaive(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            ans[i] = solve(i);
        }
        return ans;
    }

    //O(N)
    public static int[] count(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) ans[i] = ans[i / 2];
            else ans[i] = 1 + ans[i / 2];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(count(5)));
    }
}
