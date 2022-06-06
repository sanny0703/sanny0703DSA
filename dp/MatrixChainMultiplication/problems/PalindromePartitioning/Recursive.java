package MatrixChainMultiplication.problems.PalindromePartitioning;

/**
 * <h3>Palindrome Partitioning using Recursion</h3>
 * Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.<br>
 * <code>Example:<br>
 * “aba|b|bbabb|ababa” is a palindrome partitioning of “ababbbabbababa”.</code><br>
 * <b> find min no of partitions to get a palindrome partitioning</b>
 */
public class Recursive {

    public static int minPartitions(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        return solve(s, i, j);
    }

    public static int solve(String s, int i, int j) {
        if (i >= j) return 0;
        if (isPalindrome(s, i, j)) return 0;
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = solve(s, i, k) + solve(s, k + 1, j) + 1;// extra 1 cost for partition of two sub-problems
            ans = Math.min(ans, temp);
        }
        return ans;
    }

    public static boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        // 2{"n|it|im"}
        System.out.println(minPartitions("nitim"));
        // 3{“aba|b|bbabb|ababa” }
        System.out.println(minPartitions("ababbbabbababa"));
    }
}
