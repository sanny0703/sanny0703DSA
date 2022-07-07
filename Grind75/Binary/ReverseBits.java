package Binary;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * Input: n = 00000010100101000001111010011100
 * Output:    964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 */
public class ReverseBits {
    public static int reverse(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1; // multiply with 2
            if ((n & 1) == 1) result++; // if set bit add it
            n >>>= 1; // divide the n by 2(unsigned)
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(43261596));
    }
}
