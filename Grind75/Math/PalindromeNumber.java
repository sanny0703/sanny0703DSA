package Math;

/**
 * Given an integer x, return true if x is palindrome integer.
 * <p>
 * An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * For example, 121 is a palindrome while 123 is not.
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int num) {
        // num <0 false
        // if num is multiple of 10  and !=0 then false
        if (num < 0 || (num % 10 == 0 && num != 0))
            return false;
        // start adding lst digits to this number
        int revertedNumber = 0;
        while (num > revertedNumber) {
            revertedNumber = revertedNumber * 10 + num % 10;
            num = num / 10;
        }
        //when num is odd length revertedNumber/10 removes the middle digit
        return (num == revertedNumber) || (num == revertedNumber / 10);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }
}
