package Math;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * Input: x = -123
 * Output: -321
 */
public class ReverseInteger {
    //all we have to do is check for overflow in each iteration and if overflow exits just return 0
    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int curValue = ans * 10 + x % 10;
            if ((curValue - (x % 10)) / 10 != ans)
                return 0;
            ans = curValue;
            x /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
        System.out.println(reverse(Integer.MAX_VALUE));
    }
}
