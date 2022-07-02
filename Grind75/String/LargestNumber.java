package String;

import java.util.Arrays;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 * <p>
 * Since the result may be very large, so you need to return a string instead of an integer.
 * <p>
 * Input: nums = [10,2]
 * Output: "210"
 */
public class LargestNumber {
    public static String largestNumber(int[] nums) {
        int n = nums.length;
        String[] str = new String[n];
        for (int i = 0; i < n; i++) str[i] = String.valueOf(nums[i]);
        Arrays.sort(str, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1); // we want reverse order
        });
        if (str[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : str) sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{10, 2}));
    }
}
