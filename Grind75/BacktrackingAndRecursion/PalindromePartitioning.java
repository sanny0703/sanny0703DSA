package BacktrackingAndRecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 * <p>
 * A palindrome string is a string that reads the same backward as forward.
 * <p>
 * <p>
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * <p>
 * <p>
 * <p>
 * <p>
 * there could be 2^N
 * possible substrings in the worst case. For each substring, it takes O(N) time to generate substring and determine if it is a palindrome or not.
 * This gives us time complexity as O(n* 2^n)
 */
public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(s, ans, new ArrayList<>(), 0);
        return ans;
    }

    public static void backtrack(String s, List<List<String>> ans, List<String> curList, int index) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(curList));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s.substring(index, i + 1))) {
                curList.add(s.substring(index, i + 1));
                backtrack(s, ans, curList, i + 1);
                curList.remove(curList.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
