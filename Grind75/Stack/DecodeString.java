package Stack;

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

    public static void main(String[] args) {
        System.out.println(decode("3[a2[c]]"));
        System.out.println(decode("3[a]2[bc]"));
    }
}
