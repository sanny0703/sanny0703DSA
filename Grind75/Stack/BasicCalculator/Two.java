package Stack.BasicCalculator;

import java.util.Stack;

/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 * <p>
 * The integer division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 * <p>
 * <p>
 * Input: s = " 3+5 / 2 "
 * Output: 5
 */
public class Two {
    public static int withStack(String s) {
        int n = s.length();
        int sum = 0;
        int number = 0;
        char lastSign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                number = number * 10 + (c - '0');
            if ((!Character.isDigit(c) && ' ' != c) || i == n - 1) {
                switch (lastSign) {
                    case '+':
                        stack.push(number);
                        break;
                    case '-':
                        stack.push(-number);
                        break;
                    case '*':
                        stack.push(stack.pop() * number);
                        break;
                    case '/':
                        stack.push(stack.pop() / number);
                        break;
                }
                lastSign = c;
                number = 0;
            }
        }
        for (int i : stack) sum += i;
        return sum;
    }

    public static int withoutStack(String s) {
        int n = s.length();
        int sum = 0, tempSum = 0;
        int number = 0;
        char lastSign = '+';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                number = number * 10 + (c - '0');
            if ((!Character.isDigit(c) && ' ' != c) || i == n - 1) {
                switch (lastSign) {
                    case '+':
                        sum += tempSum;
                        tempSum = number;
                        break;
                    case '-':
                        sum += tempSum;
                        tempSum = -number;
                        break;
                    case '*':
                        tempSum *= number;
                        break;
                    case '/':
                        tempSum /= number;
                        break;
                }
                lastSign = c;
                number = 0;
            }
        }
        sum += tempSum;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(withStack(" 3+5 / 2 "));
        System.out.println(withoutStack("3+2*2"));
    }
}
