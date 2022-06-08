package MatrixChainMultiplication.problems.EvaluateExpression;

/**
 * <h3>Evaluate Expression To True-Boolean Parenthesization Recursion</h3>
 * Given a boolean expression with following symbols.<br>
 * Symbols<br>
 * 'T' --- true <br>
 * 'F' --- false <br>
 * And following operators filled between symbols<br>
 * Operators<br>
 * &   ---boolean AND<br>
 * |   --- boolean OR<br>
 * ^   --- boolean XOR <br>
 * Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.<br><br>
 * <code>Example:
 * Input: symbol[]    = {T, F, T}<br>
 * operator[]  = {^, &}<br>
 * Output: 2<br>
 * The given expression is "T ^ F & T", it evaluates true<br>
 * in two ways "((T ^ F) & T)" and "(T ^ (F & T))"</code>
 */
public class EvaluateToTrueRecursive {

    public static int countTrue(String s) {
        int n = s.length();
        int i = 0, j = n - 1; // since it is a string not a matrix where we need i-1
        return solve(s, i, j, true);

    }

    public static int solve(String s, int i, int j, boolean isTrue) {
        if (i > j) return 0;
        if (i == j) {
            return isTrue ? (s.charAt(i) == 'T' ? 1 : 0) : (s.charAt(i) == 'F' ? 1 : 0);
        }
        int ans = 0;
        for (int k = i + 1; k < j; k += 2) { // we have to split only at symbols{|,&,^}
            int lt = solve(s, i, k - 1, true); // left part is true
            int lf = solve(s, i, k - 1, false); // left part is false
            int rt = solve(s, k + 1, j, true);// right part is true
            int rf = solve(s, k + 1, j, false); // right part is false
            char c = s.charAt(k);
            if (c == '|') {
                if (isTrue) ans = ans + lt * rt + lf * rt + lt * rf; //possible ways to get true
                else ans = ans + lf * rf;
            } else if (c == '&') {
                if (isTrue) ans = ans + lt * rt;
                else ans = ans + lf * rt + lf * rf + lt * rf;
            } else { // ^ case(xor)
                if (isTrue) ans = ans + lt * rf + lf * rt;
                else ans = ans + lt * rt + lf * rf;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        //2"((T ^ F) & T)" and "(T ^ (F & T))"
        System.out.println(countTrue("T^F&T"));
        // There are 4 ways
        // ((T|T)&(F^T)), (T|(T&(F^T))),
        // (((T|T)&F)^T) and (T|((T&F)^T))
        System.out.println(countTrue("T|T&F^T"));
    }
}
