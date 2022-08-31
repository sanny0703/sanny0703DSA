package Stack;

import java.util.Stack;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 * <p>
 * Note that after backspacing an empty text, the text will continue empty.
 * <p>
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 */
public class BackStringCompare {
    // O(m+n) space
    public static boolean usingStack(String s, String t) {
        return build(s).equals(build(t));
    }

    public static String build(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                stack.pop();
            } else stack.push(c);
        }
        return String.valueOf(stack);
    }

    //O(1) space
    public static boolean twoPointer(String s, String t) {
        int n = s.length(), m = t.length();
        int i = n - 1, j = m - 1;
        int back;
        while (true) {
            back = 0;
            while (i >= 0 && (back > 0 || s.charAt(i) == '#')) {
                back += s.charAt(i) == '#' ? 1 : -1;
                i--;
            }
            back = 0;
            while (j >= 0 && (back > 0 || t.charAt(j) == '#')) {
                back += t.charAt(j) == '#' ? 1 : -1;
                j--;
            }
            if (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) {
                i--;
                j--;
            } else break;
        }
        return i == -1 && j == -1;
    }

    public static void main(String[] args) {
        System.out.println(usingStack("ab#c", "ad#c"));
        System.out.println(twoPointer("ab#c", "ad#c"));
    }
}
