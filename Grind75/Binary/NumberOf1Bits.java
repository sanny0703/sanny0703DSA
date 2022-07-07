package Binary;

/**
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * <p>
 * Note:
 * <p>
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
 * <p>
 * Input: n = 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 */
public class NumberOf1Bits {
    public static int count(int n) {
        int ones = 0;
        while (n != 0) {
            // binary & copies a set bit,if both are set bits
            ones += (n & 1);
            // unsigned right shift(divide by 2)
            n = (n >>> 1);
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(count(Integer.parseInt("00000000000000000000000010000000", 2)));
    }
}
