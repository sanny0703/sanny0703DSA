package longestCommonSubsequence;

/**
 * Longest Common Subsequence Problem solution using recursion<br>
 * Given two sequences, find the length of longest subsequence present in both of them.<br>
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.<br>
 *
 * <i>For example, “abc”,  “abg”, “bdf”, “aeg”,  ‘”acefg”, .. etc are subsequences of “abcdefg”.</i>
 */
public class Recursion {

    public static int lcs(String x, String y, int n, int m) {
        if (n == 0 || m == 0) return 0;
        if (x.charAt(n - 1) == y.charAt(m - 1)) return 1 + lcs(x, y, n - 1, m - 1);
        else return Math.max(lcs(x, y, n - 1, m), lcs(x, y, n, m - 1));
    }

    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";
        //4 {a,b,d,h}
        long a = System.nanoTime();
        System.out.println(lcs(x, y, x.length(), y.length()));
        System.out.println((System.nanoTime()-a)/10000);
    }

}
