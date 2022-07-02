package Stack;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 * <p>
 * Note that division between two integers should truncate toward zero.
 * <p>
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.
 * <p>
 * <p>
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 */
public class EvaluateReversePolishNotation {
    public static int evaluate(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+"))
                stack.push(stack.pop() + stack.pop());
            else if (token.equals("-"))
                stack.push(-stack.pop() + stack.pop());
            else if (token.equals("*"))
                stack.push(stack.pop() * stack.pop());
            else if (token.equals("/")) {
                int temp = stack.pop();
                stack.push(stack.pop() / temp);
            } else stack.push(Integer.parseInt(token));
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        System.out.println(evaluate(new String[]{"2", "1", "+", "3", "*"}));
    }
}
