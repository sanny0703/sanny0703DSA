package Stack;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * <p>
 * The test cases are generated so that the length of the output will never exceed 10^5.
 * <p>
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 */
public class DecodeString {
    public static String decode(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))
                count = count * 10 + (c - '0');
            else if (c == '[') {
                intStack.push(count);
                count = 0;
                strStack.push(ans);
                ans = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = ans;
                ans = strStack.pop();
                for (count = intStack.pop(); count > 0; count--) ans.append(temp);
            } else ans.append(c);
        }
        return ans.toString();
    }

    public static String recursive(String s) {
        Queue<Character> queue = new ArrayDeque<>();
        for (char c : s.toCharArray()) queue.offer(c);
        return helper(queue);
    }

    public static String helper(Queue<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (Character.isDigit(c))
                num = num * 10 + (c - '0');
            else if (c == '[') {
                String sub = helper(queue);
                for (int i = num; i > 0; i--) sb.append(sub);
                num = 0;
            } else if (c == ']') break;
            else sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decode("3[a2[c]]"));
        System.out.println(decode("3[a]2[bc]"));
        System.out.println(recursive("3[a2[c]]"));
        System.out.println(recursive("3[a]2[bc]"));
    }
}
