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
            sb.append(s.length()).append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public static List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        int endIndex = 0;
        while (endIndex < s.length()) {
            StringBuilder length = new StringBuilder();
            while (endIndex < s.length() && Character.isDigit(s.charAt(endIndex))) {
                length.append(s.charAt(endIndex));
                endIndex++;
            }
            endIndex++; // skip the #
            StringBuilder str = new StringBuilder();
            int i;
            for (i = endIndex; i < endIndex + Integer.parseInt(length.toString()); i++) {
                str.append(s.charAt(i));
            }
            list.add(str.toString());
            endIndex = i;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(encode(Arrays.asList("Sanjay", "Kumar", "Uppala")));
        System.out.println(decode("6#Sanjay5#Kumar6#Uppala"));
    }
}

