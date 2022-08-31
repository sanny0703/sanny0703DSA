package String;

/**
 * Convert a non-negative integer num to its English words representation.
 * <p>
 * Input: num = 123
 * Output: "One Hundred Twenty Three"
 * <p>
 * Input: num = 12345
 * Output: "Twelve   Thousand Three  Hundred Forty Five"
 * Input: num = 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
public class IntegerToEnglishWords {
    private static final String[] BELOW_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public static String convert(int num) {
        if (num == 0)
            return "Zero";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0)
                sb.insert(0, helper(num % 1000) + THOUSANDS[i] + " ");
            num /= 1000;
            i++;
        }
        return sb.toString();
    }

    public static String helper(int num) {
        if (num == 0)
            return "";
        if (num < 20)
            return BELOW_TWENTY[num] + " ";
        if (num < 100)
            return new StringBuilder().append(TENS[num / 10]).append(" ").append(helper(num % 10)).toString();
        return new StringBuilder().append(BELOW_TWENTY[num / 100]).append(" Hundred ").append(helper(num % 100)).toString();

    }

    public static void main(String[] args) {
        System.out.println(convert(245));
        System.out.println(convert(454646354));
        System.out.println(convert(1000));
    }
}
