package Stack.BasicCalculator;

import java.util.Stack;

/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 * <p>
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 */
public class One {
    // the input is always valid and parenthesis are balanced
    public static int calculate(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int result = 0, sign = 1, number = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                number = number * 10 + (c - '0');
            else if (c == '+') {
                result += sign * number;
                sign = 1;
                number = 0;
            } else if (c == '-') {
                result += sign * number;
                sign = -1;
                number = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // sign on top of stack
                result += stack.pop(); // result on top
            }
        }
        if (number != 0) result += sign * number;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
