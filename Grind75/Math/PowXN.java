package Math;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * <p>
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * In order to improve efficiency we will opt for Binary Exponentiation using which we can calculate xn using O log2(N) multiplications.
 * <p>
 * Basic Idea is to divide the work using binary representation of exponents
 * i.e. is to keep multiplying pow with x, if the bit is odd, and multiplying x with itself until we get 0
 * We will use very 1st example of 1st Approach i.e.
 * x = 7, n = 11 and pow = 1
 * Here, we have to calculate 711
 * Binary of n i.e. (11)10 is (1011)2
 * 1   0   1   1
 * 23  22  21  20   <-- Corresponding place values of each bit
 * <p>
 * OR we can also write this as
 * 1 0 1 1
 * 8 4 2 1 <-- Corresponding place values of each bit
 * <p>
 * Now, 78 × 72 × 71 == 711 as 7(8 + 2 + 1) == 711
 * NOTE: We have not considered 74 in this case as the 4th place bit is OFF
 * <p>
 * So, 78 × 72 × 71 == 5764801 × 49 × 7 == 1977326743 <-- Desired Output
 * Now, applying logic keeping this concept in mind
 */
public class PowXN {
    // naive method multiply x with itself n time
    //O(N)
    // we can use bit manipulation O(logN)
    public static double pow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        double pow = 1;
        while (n != 0) {
            if ((n & 1) != 0) // if n is odd
                pow *= x;
            x *= x;
            n >>>= 1;
        }
        return pow;
    }

    public static void main(String[] args) {
        System.out.println(pow(7, 11));
    }
}
