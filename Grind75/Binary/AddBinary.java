package Binary;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {
    public static String add(String a, String b) {
        int n = a.length(), m = b.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = n - 1, j = m - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(add("1010", "1011"));
    }
}
