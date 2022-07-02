package String;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 */
public class LongestCommonPrefix {
    public static String longestPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // while the prefix won't be the prefix of the current String,keep on removing one character
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                // if prefix becomes empty,just return it
                if (prefix.equals("")) return prefix;
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(longestPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
