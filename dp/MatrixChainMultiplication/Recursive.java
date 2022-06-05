package MatrixChainMultiplication;

/**
 * <h3>Matrix Chain Multiplication using Recursion</h3>
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together.<br>
 * The problem is not actually to  perform the multiplications, but merely to decide in which order to perform the multiplications.
 * <code>
 * <i>Example:</i><br>
 * arr[] = {40,20,30,10,30}<br>
 * A1 = 40*20<br>
 * A2 = 20*30<br>
 * A3 = 30*10<br>
 * A4 = 10*30<br>
 * </code>
 */
public class Recursive {

    public static int mcm(int[] arr) {
        int n = arr.length;
        return solve(arr, 1, n - 1);
    }

    public static int solve(int[] arr, int i, int j) {
        if (i >= j)  // empty and single element case
            return 0;
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        //2600
        // (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30
        System.out.println(mcm(arr));

        int[] arr2 = {10, 20, 30, 40, 30};
        // 30000
        //((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30
        System.out.println(mcm(arr2));
    }
}
