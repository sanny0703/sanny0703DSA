package DynamicProgramming;

/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * <br>
 * 'A' -> "1"<br>
 * 'B' -> "2"<br>
 * ...
 * <br>
 * 'Z' -> "26"<br>
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways).<br>
 * <code>For example, "11106" can be mapped into:
 * <br>
 * "AAJF" with the grouping (1 1 10 6)<br>
 * "KJF" with the grouping (11 10 6)<br>
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".</code>
 * <br><br>
 * Given a string s containing only digits, return the number of ways to decode it.
 */
public class DecodeWays {
    public static int decodeWays(String s) {
        int n = s.length();
        int[] dp = new int[n];
        if (s.charAt(0) != '0') dp[0] = 1; // if it's a 0 then dp[0]=0
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != '0') dp[i] = dp[i - 1]; // if it's 0 then dp[i]=0;
            String st = s.substring(i - 1, i + 1);
            if (Integer.parseInt(st) >= 1 && Integer.parseInt(st) <= 26 && s.charAt(i - 1) != '0') {
                if (i - 2 < 0) dp[i] += 1;
                else dp[i] += dp[i - 2];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(decodeWays("11106"));
    }
}
