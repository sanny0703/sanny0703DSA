package BacktrackingAndRecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParenthesis {
    public static List<String> generate(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(n, n, ans, sb);
        return ans;
    }

    public static void backtrack(int open, int close, List<String> ans, StringBuilder sb) {
        if (open == 0 && close == 0) {
            ans.add(sb.toString());
            return;
        }
        if (open > 0) {
            sb.append("(");
            backtrack(open - 1, close, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close > open) {
            sb.append(")");
            backtrack(open, close - 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generate(3));
    }
}
