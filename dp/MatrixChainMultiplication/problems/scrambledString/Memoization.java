package MatrixChainMultiplication.problems.scrambledString;

import java.util.HashMap;
import java.util.Map;

public class Memoization {
    private static Map<String, Boolean> memo;

    public static boolean isScrambledString(String a, String b) {
        if (a.length() != b.length()) return false;
        memo = new HashMap<>();
        return solve(a, b);
    }

    public static boolean solve(String a, String b) {
        String key = a + "_" + b;
        if (memo.containsKey(key)) return memo.get(key);
        if (a.equals(b)) {
            memo.put(key, true);
            return true;
        }
        int n = a.length();
        if (n <= 1) {
            memo.put(key, false);
            return false;
        }
        boolean ans = false;
        for (int i = 1; i < n; i++) {
            boolean cond1 = solve(a.substring(0, i), b.substring(n - i)) && solve(a.substring(i), b.substring(0, n - i));
            boolean cond2 = solve(a.substring(0, i), b.substring(0, i)) && solve(a.substring(i), b.substring(i));
            if (cond1 || cond2) {
                ans = true;
                break;
            }
        }
        memo.put(key, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(isScrambledString("great", "eatgr"));
        System.out.println(isScrambledString("phqtrnilf", "ilthnqrpf"));
    }
}
