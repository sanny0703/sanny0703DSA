package BacktrackingAndRecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * <p>
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class LetterCombinationOfAPhoneNumber {
    public static List<String> combinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty())
            return ans;
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            int size = ans.size();
            while (size-- > 0) {
                String s = ans.remove(0); // we want the behaviour of queue
                for (char c : mapping[index].toCharArray())
                    ans.add(s + c);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(combinations("23"));
    }
}
