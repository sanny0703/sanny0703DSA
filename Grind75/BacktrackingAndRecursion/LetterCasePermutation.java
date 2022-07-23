package BacktrackingAndRecursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create.
 * <p>
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * <p>
 * Input: S = "12345"
 * Output: ["12345"]
 */
public class LetterCasePermutation {
    public static List<String> permute(String s) {
        char[] arr = s.toCharArray();
        List<String> ans = new ArrayList<>();
        backtrack(arr, 0, ans);
        return ans;
    }

    public static void backtrack(char[] arr, int index, List<String> ans) {
        if (index == arr.length) {
            ans.add(new String(arr));
        } else {
            if (Character.isLetter(arr[index])) {
                arr[index] = Character.toUpperCase(arr[index]);
                backtrack(arr, index + 1, ans);
                arr[index] = Character.toLowerCase(arr[index]);
                backtrack(arr, index + 1, ans);
            } else {
                backtrack(arr, index + 1, ans);
            }
        }

    }

    public static List<String> letterCasePermutation(String s) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add(s);
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                int size = queue.size();
                while (size-- > 0) {
                    String cur = queue.poll();
                    char[] arr = cur.toCharArray();
                    arr[i] = Character.toUpperCase(arr[i]);
                    queue.offer(String.valueOf(arr));
                    arr[i] = Character.toLowerCase(arr[i]);
                    queue.offer(String.valueOf(arr));
                }
            }
        }
        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        System.out.println(permute("a1b2"));
    }
}
