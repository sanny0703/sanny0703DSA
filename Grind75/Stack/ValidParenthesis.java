package Stack;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 */
public class ValidParenthesis {
    public static boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                else return false;
            } else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') stack.pop();
                else return false;
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else return false;
            } else stack.push(c);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}
