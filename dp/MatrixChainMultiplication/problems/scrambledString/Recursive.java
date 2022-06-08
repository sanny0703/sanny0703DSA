package MatrixChainMultiplication.problems.scrambledString;

/**
 * <h3>Scramble String using Recursion</h3>
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.<br>
 * Below is one possible representation of A = “great”:<br>
 * great<br>
 * /    \<br>
 * gr    eat<br>
 * / \    /  \<br>
 * g   r  e   at<br>
 * / \<br>
 * a   t<br>
 * To scramble the string, we may choose any non-leaf node and swap its two children.<br>
 * <p>
 * For example, if we choose the node “gr” and swap its two children, it produces a scrambled string “rgeat”.<br>
 * <p>
 * rgeat<br>
 * /    \<br>
 * rg    eat<br>
 * / \    /  \<br>
 * r   g  e   at<br>
 * / \<br>
 * a   t<br>
 * We say that “rgeat” is a scrambled string of “great”.<br>
 * <p>
 * Similarly, if we continue to swap the children of nodes “eat” and “at”, it produces a scrambled string “rgtae”.<br>
 * <p>
 * rgtae<br>
 * /    \<br>
 * rg    tae<br>
 * / \    /  \<br>
 * r   g  ta  e<br>
 * / \<br>
 * t   a<br>
 * We say that “rgtae” is a scrambled string of “great”.<br>
 */
public class Recursive {

    public static boolean isScrambledString(String a, String b) {
        if (a.length() != b.length()) return false;
        return solve(a, b);
    }

    public static boolean solve(String a, String b) {
        if (a.equals(b)) return true;
        int n = a.length();
        if (n <= 1) return false;
        boolean ans = false;
        for (int i = 1; i < n; i++) {
            boolean cond1 = solve(a.substring(0, i), b.substring(n - i)) && solve(a.substring(i), b.substring(0, n - i));
            boolean cond2 = solve(a.substring(0, i), b.substring(0, i)) && solve(a.substring(i), b.substring(i));
            if (cond1 || cond2) {
                ans = true;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(isScrambledString("great", "eatgr"));
        System.out.println(isScrambledString("phqtrnilf", "ilthnqrpf"));
    }

}
