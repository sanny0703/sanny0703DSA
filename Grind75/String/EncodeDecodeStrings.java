package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 * <p>
 * Please implement encode and decode
 * <p>
 * Output: ["lint","code","love","you"]
 * Explanation:
 * One possible encode method is: "lint:;code:;love:;you"
 */
public class EncodeDecodeStrings {
    public static String encode(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s.length() + "#");
            sb.append(s);
        }
        return sb.toString();
    }

    public static List<String> decode(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < n) {
            String length = "";
            while (Character.isDigit(s.charAt(i))) {
                length += s.charAt(i);
                i++;
            }
            i += 1;
            String word = "";
            for (int index = i; index < i + Integer.parseInt(length); index++) {
                word += s.charAt(index);
            }
            ans.add(word);
            i = i + Integer.parseInt(length);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(encode(Arrays.asList("Sanjay", "Kumar", "Uppala")));
        System.out.println(decode("6#Sanjay5#Kumar6#Uppala"));
    }
}

